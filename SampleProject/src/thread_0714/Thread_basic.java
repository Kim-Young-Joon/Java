package thread_0714;

class MyThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Hello");
	}
}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("이것도 실행됨!");
		
	}
}

public class Thread_basic {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		
		MyThread2 a = new MyThread2();
		Thread t1 = new Thread(a);
		t1.start();
		
		System.out.println("안녕하세요!");
	}
}
