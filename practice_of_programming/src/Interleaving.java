import java.util.Random;


/**
 * A simple counter class. Here a counter is continually
 * incremented and its value is printed to the terminal at
 * each step. The delay between increments is determined
 * randomly and the whole thing is implemented as a Thread
 * class, so that we can run more than one counter at a time.
 * 
 * @author Dominic Verity
 *
 */
public class CounterThread extends Thread {

	private int count;
	private String name;
	
	public CounterThread(String name) {
		this.name = name;
		count = 0;
	}
	
	public void run() {
		doCounting();
	}

	/**
	 * Our counter method, called from the run() method.
	 */
	private void doCounting() {
		Random generator = new Random();
		
		while (true) {
			System.out.print(name);
			System.out.print(": ");
			System.out.println(count++);
			
			try {
				Thread.sleep(Math.abs(generator.nextLong()) % 1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	/**
	 * Main method, starts two counter threads and then retires.
	 */
	public static void main(String[] args) {
		new CounterThread("First Thread").start();
		new CounterThread("Second Thread").start();
		new CounterThread("Third Thread").start();
	}
}
