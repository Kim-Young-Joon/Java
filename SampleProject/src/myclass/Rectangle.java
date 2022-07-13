package myclass;

public class Rectangle extends Shape implements Movable {

	private int width;
	
	public Rectangle() {super();}
	public Rectangle(int width, int x, int y) {
		super(new Point(x, y));
		this.width = width;
	}
	
	@Override
	public void move(int x, int y) {
		this.getPoint().setX(this.getPoint().getX() + x + 2); 
		this.getPoint().setY(this.getPoint().getY() + y + 2);
	}

	@Override
	public double getArea() {
		return this.getWidth() * this.getWidth();
	}

	@Override
	public double getCircumference() {
		return 4 * this.getWidth();
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public String toString() {
		return this.getWidth() + "\t" + this.getPoint().getX() + "\t"
				+ this.getPoint().getY();
	}
}
