

public class Sphere {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = Math.abs(radius);
	}

	public Sphere(double radius) {
		setRadius(radius);
	}
	
	public Sphere() {
		setRadius(0);
	}

	/**
	 * 
	 * Formula for volume of a sphere is 4/3 * pi * r * r * r
	 * 
	 * IMPLEMENTATION IS DELIBERATELY INCORRECT
	 * @return
	 */
	public double volume() {
		return 4 / 3 * Math.PI * radius * radius * radius;
	}
	
	public double surfaceArea() {
		return 4 * Math.PI * radius * radius;
	}
}
