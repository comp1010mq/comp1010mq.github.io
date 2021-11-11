package interrupt;

public class CancellationToken {
	private volatile boolean isCancelled = false;
	public void cancel() {
		isCancelled = true;
	}
	public boolean cancelled() {
		return isCancelled;
	}
}
