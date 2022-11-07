
public class Cylinder extends Circle{
	private double height = 1.0;
	public Cylinder() {
	}
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}
	public Cylinder(double radius, double height, String color) {
		super(radius, color);
		this.height = height;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	public double getVolumn() {
		return PIE*super.getRadius()*super.getRadius()*height;
	}
	
}
