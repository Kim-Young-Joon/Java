package lecture0712_3;

class Human {
	
}

class Person {
	public Person() {
		System.out.println("AA");
	}
	String name;	// 이름
	String mobile;	// 전화번호
}

class Student extends Person {
	public Student() {
		System.out.println("BB");
		
	}
	
	String dept;	// 학과

}

public class Main {
	public static void main(String[] args) {
//		Person p = new Person();
		Student s = new Student();
//		Person s = new Student();
//		Object s = new Student();
		
		// is-a relationship
		// [subclass] is a [superclass]
		
		
	}
}
