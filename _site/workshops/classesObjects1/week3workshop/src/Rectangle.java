public class Rectangle {
	private double width;
	private double height;
	
	/*
	 * create a public interface that
	 * let us access data members
	 * 
	 * getters: read data members
	 * setters: assign values to data members
	 */
	
	//getters
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	//setters
	public void setWidth(double w) {
		width = Math.abs(w);
	}
	
	public void setHeight(double h) {
		height = Math.abs(h);
	}
	
	//parameterized constructors
	public Rectangle(double w, double h) {
		setWidth(w);
		setHeight(h);
	}

	public Rectangle(double side) {
		// TODO Auto-generated constructor stub
		setWidth(side);
		setHeight(side);
	}
	
	//default constructor
	public Rectangle() {
		setWidth(0);
		setHeight(0);
	}
	
	public double area() {
		return width * height;
	}
	
	public double perimeter() {
		return 2*(width + height);
	}
	
	public double getLongerSide() {
		if(width > height)
			return width;
		else
			return height;
	}
	
	public double getShorterSide() {
		if(width < height)
			return width;
		else
			return height;
	}
	
	public boolean isSquare() {
		return width == height;
	}
	
	public double diagnol() {
		return Math.sqrt(width*width + height*height);
	}
	
	public String toString() {
		return width+" by "+height;
	}
	
	/**
	 * 
	 * @param other
	 * @return 1 if calling objects area is more than parameter objects area
	 * -1 if calling objects area is less than parameter objects area
	 * 0 if calling objects area is equal to parameter objects area
	 */
	public int compareTo(Rectangle other) {
		if(area() > other.area())
			return 1;
		if(area() < other.area())
			return -1;
		return 0;
	}
}
