/**
 * This file is part of a project entitled Week8Samples which is provided as
 * sample code for the following Macquarie University unit of study:
 * 
 * COMP229 "Object Oriented Programming Practices"
 * 
 * Copyright (c) 2011-2012 Dominic Verity and Macquarie University.
 * 
 * Week8Samples is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * Week8Samples is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Week8Samples. (See files COPYING and COPYING.LESSER.) If not, see
 * <http://www.gnu.org/licenses/>.
 */

package interrupt_soln;
import java.util.Random;

/**
 * An application which shows how one thread may request for the execution of
 * another thread to be interrupted.
 * 
 * @author Dominic Verity
 *
 */

public class Interrupt {
	
	static CancellationToken token = new CancellationToken();
	static Thread counterOne = new Counter("one", token);
	static Thread counterTwo = new Counter("two", token);
	static Thread mInterrupter = new Interrupter(token);

	/**
	 * Create a Counter and an Interrupter thread and start
	 * the Counter thread. This in turn will start the Interrupter.
	 * @param args
	 */
	public static void main(String[] args) {
		counterOne.setPriority(Thread.MAX_PRIORITY);
		counterTwo.setPriority(Thread.MIN_PRIORITY);
		counterOne.start();
		counterTwo.start();
		mInterrupter.start();
	}
	
	/**
	 * This class implements a Thread which counts backwards
	 * from 100 and restarts its count whenever it is interrupted
	 * 
	 * When this thread completes its countdown to 1 it terminates.
	 * 
	 * @author Dominic Verity
	 *
	 */
	private static class Counter extends Thread {
		private static final int STARTING_COUNT = 100;
		private int mCount = STARTING_COUNT;	
		private String name = "anon";
		CancellationToken t;
		
		public Counter(String name, CancellationToken t){this.t = t;this.name = name;}
		
		public void run() {
			while (mCount > 0 && !token.cancelled()) {
				System.out.print(name + ": ");
				System.out.println(mCount--);

				if (interrupted())
					resetOrDie();

				try {
					sleep(50);
				} catch (InterruptedException e) {
					resetOrDie();
				}
			}
			token.cancel();
		}
		private void resetOrDie(){
			if (counterOne.isAlive() && counterTwo.isAlive())
				mCount = STARTING_COUNT;
			else
				mCount = 0;
		}
	}
	
	/**
	 * This thread interrupts the Counter threads at random intervals.
	 * It checks to make sure that the corresponding Counter is still
	 * alive, and terminates as soon as it detects that that thread
	 * has died.
	 * 
	 * @author Dominic Verity
	 *
	 */
	private static class Interrupter extends Thread {
		private Random mGenerator = new Random();
		private CancellationToken t;
		public Interrupter(CancellationToken t){super();this.t = t;}
		
		public void run() {
			while (!t.cancelled()) {
				long randOne = Math.abs(mGenerator.nextLong()) % 6000;
				long randTwo = Math.abs(mGenerator.nextLong()) % 6000;
				long larger = Math.max(randOne, randTwo);
				long diff = Math.abs(randOne - randTwo);
				try {sleep(larger);} catch (InterruptedException e) {}
				counterOne.interrupt();
				try {sleep(diff);} catch (InterruptedException e) {}
				counterTwo.interrupt();
			} 
		}
	}
}
