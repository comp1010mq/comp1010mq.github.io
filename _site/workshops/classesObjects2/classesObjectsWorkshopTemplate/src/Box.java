

public class Box {
	private double capacity;
	
	public void setCapacity(double capacity) {
		capacity = Math.abs(capacity);
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public String toString() {
		return "Box with capacity "+capacity;
	}
	
	/**
	 *
	 * @param other
	 * @return
	 * 1, if the calling object has a higher capacity than the parameter object
	 * -1, if the calling object has a lower capacity than the parameter object
	 * 0, if the calling object has the same capacity as the parameter object
	 */
	public int compareTo(Box other) {
		return 0; //this statement is there just to avoid compilation errors in the template
	}
	
	/**
	 *
	 * @param other
	 * @return
	 * true, if the calling object has the same capacity as the parameter object
	 * false, if the calling object has a different capacity from the parameter object
	 */
	public boolean equals(Box other) {
		return false; //this statement is there just to avoid compilation errors in the template
	}
}
