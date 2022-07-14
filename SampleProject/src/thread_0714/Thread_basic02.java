package thread_0714;

class ThreadEx_01_1 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName()); // 현재 실행되는 Thread 이름 출력
		}
	}
}

class ThreadEx_01_2 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()); // 현재 실행되는 Thread 이름 출력
		}
	}
}

public class Thread_basic02 {
	public static void main(String[] args) {
		ThreadEx_01_1 t1 = new ThreadEx_01_1();
		
		ThreadEx_01_2 r = new ThreadEx_01_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		System.out.println("main Thread 종료");
	}
}
