package thread_0714;

// Daemon Thread
public class Thread_Daemon implements Runnable {
	static boolean autoSave = false;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				// 이 method를 호출한 Thread가 sleep
			} catch (InterruptedException e) {
				
			}
			
			if(autoSave) {
				System.out.println("자동저장 완료");
			}
			
			
			
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new Thread_Daemon());
		
		// main Thread의 daemon Thread로 t 를 설정하겠다.
		t.setDaemon(true);
		
		t.start();
		
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				// 이 method는 main Thread가 호출하고 있으므로 main Thread sleep
			} catch(Exception e) {
				
			}
			System.out.println(i);
			
			if(i == 5) {
				autoSave = true;
			}
			
		}
		
		// t를 main Thread의 Daemon Thread로 지정했기 때문에 main Thread가 종료되면서
		// t도 함께 종료되는 것을 볼 수 있다.
	}
}
