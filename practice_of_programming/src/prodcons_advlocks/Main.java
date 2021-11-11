package prodcons_advlocks;

public class Main {

	public static void main(String[] args) {
		BoundedBuffer<Integer> vBuffer = new BoundedBuffer<Integer>();
		
		// Create consumer and producer threads which talk with that buffer
		Producer vProducer = new Producer(vBuffer);
		Consumer vConsumer = new Consumer(vBuffer);
		
		// And start them....
		vProducer.start();
		vConsumer.start();
	}

}
