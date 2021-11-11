package prodcons_advlocks;

import java.util.Random;

public class Producer extends Thread {
	
	private BoundedBuffer<Integer> mBuffer;
	
	Producer (BoundedBuffer<Integer> pBuffer) {
		mBuffer = pBuffer;
	}

	public void run() {
		Random vRandom = new Random();
		
		try {
			while (!interrupted()) {
				long vWait = Math.abs(vRandom.nextInt()) % 1000;
				
				// Now sleep.
				sleep(vWait);
				
				// Generate a value to add to the buffer.
				int vValue = vRandom.nextInt();
				mBuffer.put(vValue);
				
				// And print it.
				System.out.println("Value produced: " + vValue);
			}
		} catch (InterruptedException pExn) {
			// Nothing to do here, just exit.
		}
	}

}
