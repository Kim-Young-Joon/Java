package thread_0714;

class ThreadEx_05 implements Runnable {
	@Override
	public void run() {
		while(true) {
			// Thread 이름 출력
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			
			}
		}
	}
}


public class Thread_method_deprecated {
	public static void main(String[] args) {
		ThreadEx_05 r = new ThreadEx_05();
		Thread t1 = new Thread(r, "*"); // 두번째 인자는 Thread의 이름
		Thread t2 = new Thread(r, "**");
		Thread t3 = new Thread(r, "***");
		
		t1.start();
		t2.start();
		t3.start();
		
		// Deprecated
		try {
			Thread.sleep(2000);
			t1.suspend(); // t1 일시중지
			
			Thread.sleep(2000);
			t2.suspend(); // t2 일시중지
			
			Thread.sleep(2000);
			t1.resume(); // t1 다시 시작
			
			Thread.sleep(2000);
			t1.stop(); // t1 중지
			
			Thread.sleep(2000);
			t2.stop(); // t3 중지
			
			Thread.sleep(2000);
			t3.stop(); // t3 중지
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
