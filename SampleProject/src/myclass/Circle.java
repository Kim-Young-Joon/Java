package myclass;

public class Circle extends Shape implements Movable {

	private int radius;
	
	public Circle() {super();}
	public Circle(int radius, int x, int y) {
		super(new Point(x, y));
		this.radius = radius;
	}
	
	@Override
	public void move(int x, int y) {
		this.getPoint().setX(this.getPoint().getX() + x + 1); 
		this.getPoint().setY(this.getPoint().getY() + y + 1);
	}

	@Override
	public double getArea() {
		return this.getRadius() * this.getRadius() * Math.PI;
	}

	@Override
	public double getCircumference() {
		return this.getRadius() * 2 * Math.PI;
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return this.getRadius() + "\t" + this.getPoint().getX() + "\t"
				+ this.getPoint().getY();
	}
}
