package prodcons_advlocks;

public class BoundedBuffer<T> {

	private final static int CAPACITY = 3;
	private T[] mValues;
	private int mNext;
	
	private int mHead;
	
	public BoundedBuffer () {
		mValues = (T[]) new Object[CAPACITY];
		mNext = 0;
		mHead = 0;
	}
	
	public void put(T pValue) throws InterruptedException {
		// First check to see if there is space in the buffer.
		while (mNext - mHead >= CAPACITY) {
			System.out.println("Waiting for some buffer space!");
			Thread.sleep(1000);
		}
		
		// Now we know there is space so add the new value.
		mValues[mNext % CAPACITY] = pValue;
		mNext++;		
	}
	
	public T get() throws InterruptedException {
		// First check to see if there is anything in the buffer.
		while (mNext - mHead <= 0) {
			System.out.println("Waiting for a value to become available!");
			Thread.sleep(1000);
		}
		
		// Now we know that a value is present, so get the head value
		T vResult = mValues[mHead++];
		
		// Adjust if we've wrapped around in the buffer.
		if (mHead >= CAPACITY) {
			mHead -= CAPACITY;
			mNext -= CAPACITY;
		}
		
		// And return the retrieved value.
		return vResult;
	}
}
