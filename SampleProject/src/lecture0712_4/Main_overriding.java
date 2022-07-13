package lecture0712_4;

class Person {
	String name;
	String mobile;
	public void printAll() {
		System.out.println("모두 출력!!");
	}
}

class Student extends Person {
	String name;
	// 필드를 재정의(오버라이딩이라고 부르지 않음), 일반적이지 않고 권장하지도 않음
	String dept;

	// default constructor
	public Student() {
		this("홍길동");
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public void printAll() {
		System.out.println("오버라이딩");
	}
}

public class Main_overriding {
	public static void main(String[] args) {
		Student s = new Student();
		
		s.printAll();
		
	}
}
