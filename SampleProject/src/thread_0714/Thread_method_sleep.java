package thread_0714;

class ThreadEx_03_1 extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("<<Thread 1 종료>>");
	}
}

class ThreadEx_03_2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("<<Thread 2 종료>>");
	}
}

public class Thread_method_sleep {
	public static void main(String[] args) {
		ThreadEx_03_1 t1 = new ThreadEx_03_1();
		ThreadEx_03_2 t2 = new ThreadEx_03_2();
		
		t1.start();
		t2.start();
		
		try {
			t1.sleep(1000);
//			t2.sleep(2000);
			// sleep 앞에 무슨 Thread를 붙이던, 이 코드에 위치에 따라 어떤 Thread가 sleep 하는지가 바뀌게 된다.
			// 이 부분에서는 main Thread가 sleep 하게 된다.
			
		} catch (Exception e) {
			
		}
		System.out.println("<<main Thread 종료>>");
		
	}
}
