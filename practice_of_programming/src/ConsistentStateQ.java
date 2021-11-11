import java.util.Random;

public class ConsistentStateQ {

	static ConsistentStateQ instance = null;
	static Thread updateThread = null;
	static Thread validateThread = null;
	
	private long value=0;
	private long valueTimesTwo=0;
	
	/**
	 * Sets the state of our object.
	 *  
	 * @param pValue the value to update the current state with,
	 */
	public void setValues(long value) {
		this.value = value;
		doPause(3);
		valueTimesTwo = value * 2;
	}
	
	/**
	 * Checks to see if the current state of our object is
	 * consistent.
	 * 
	 * @return true if it is.
	 */
	public boolean isConsistent() {
		return (value * 2 == valueTimesTwo);
	}
	
	/**
	 * Utility routine - pauses our thread by calling
	 * sleep and supressing any InterruptedException.
	 */
	private static void doPause(long pPause) {
		try {
			Thread.sleep(pPause);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Main method, creates and starts two threads:
	 * 
	 * updateThread which updates an InconsistentState object with a 
	 *               random value at regular intervals.
	 *               
	 * validateThread which checks repeatedly to see if the object is
	 *                 still in a consistent state.
	 *                 
	 * @param args
	 */
	public static void main(String[] args) {
		instance = new ConsistentStateQ();
		
		updateThread = new Thread() {
			public void run() {
				Random vGenerator = new Random();
				while (true) {
					long vNewValue = Math.abs(vGenerator.nextLong()) % 10000;

					System.out.print("Setting value to: ");
					System.out.println(vNewValue);
					
					instance.setValues(vNewValue);

					doPause(7);
				}
			}
		};
		
		validateThread = new Thread() {
			public void run() {
				while (true) {
					System.out.print("State is currently ");
					if (instance.isConsistent())
						System.out.println("consistent.");
					else
						System.out.println("inconsistent!!!");

					doPause(11);
				}
			}
		};
		
		updateThread.start();
		validateThread.start();
	}
	


}
