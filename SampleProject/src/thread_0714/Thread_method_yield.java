package thread_0714;

class ThreadEx_06 implements Runnable {
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	@Override
	public void run() {
		// busy waiting 의 문제 발생
		// => suspend 상태일때, 아무일도 하지 않는 while문을 계속해서 도는 것이 아닌
		// yield() 를 통해 다른 Thread에게 양보
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			} else {
				Thread.yield();
			}
		}
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
	}
}

public class Thread_method_yield {
	public static void main(String[] args) {
		ThreadEx_06 r1 = new ThreadEx_06();
		ThreadEx_06 r2 = new ThreadEx_06();
		ThreadEx_06 r3 = new ThreadEx_06();
		
		Thread t1 = new Thread(r1, "*");
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend(); // t1 일시중지
			
			Thread.sleep(2000);
			r2.suspend(); // t2 일시중지
			
			Thread.sleep(2000);
			r1.resume(); // t1 다시 시작
			
			Thread.sleep(2000);
			r1.stop(); // t1 중지
			
			Thread.sleep(2000);
			r2.stop(); // t3 중지
			
			Thread.sleep(2000);
			r3.stop(); // t3 중지
			
		} catch (Exception e) {
			
		}
	}
}
