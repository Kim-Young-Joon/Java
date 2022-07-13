package myclass;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>(); 
		shapes.add(new Rectangle(4, 7, 5));
		shapes.add(new Rectangle(5, 4, 6));
		shapes.add(new Circle(6, 6, 7));
		shapes.add(new Circle(7, 8, 3));
		
		System.out.println("구분\t\t길이\tX좌표\tY좌표\tArea\tCircumference");
		for(Shape s : shapes) {
			// s.getClass().getSimpleName() 을 통해 class 명을 찍을 수도 있다.
			if(s instanceof Rectangle) {
				System.out.print("Rectangle\t");
			} else if(s instanceof Circle) {
				System.out.print("Circle\t\t");
			}
			System.out.print(s);
			System.out.print("\t" + Math.round(s.getArea()));
			System.out.println("\t" + Math.round(s.getCircumference()));
		}
		
		// 좌표 이동 (x : 10, y : 10)
		for(Shape s : shapes) {
			((Movable)s).move(10, 10);
		}
		
		System.out.println("이동 후...");
		for(Shape s : shapes) {
			if(s instanceof Rectangle) {
				System.out.print("Rectangle\t");
			} else if(s instanceof Circle) {
				System.out.print("Circle\t\t");
			}
			System.out.println(s);
		}
	}
}
