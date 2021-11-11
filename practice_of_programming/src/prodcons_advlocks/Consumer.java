package prodcons_advlocks;

import java.util.Random;

public class Consumer extends Thread {
	
	private BoundedBuffer<Integer> mBuffer;
	
	Consumer (BoundedBuffer<Integer> pBuffer) {
		mBuffer = pBuffer;
	}

	@Override
	public void run() {
		Random vRandom = new Random();
		
		try {
			while (!interrupted()) {
				long vWait = Math.abs(vRandom.nextInt()) % 1000;

				sleep(vWait);
				
				// Finally get a value from the buffer
				int vValue = mBuffer.get();
				
				// And print it.
				System.out.println("Value consumed: " + vValue);
			}
		} catch (InterruptedException pExn) {
			// Nothing to do here, just exit.
		}
	}
}
