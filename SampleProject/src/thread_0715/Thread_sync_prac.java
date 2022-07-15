package thread_0715;

class MyObj {
	public synchronized void myPrint() {
		notify();
		
		System.out.println(Thread.currentThread().getName());
		
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}


class ThreadPrac implements Runnable {
	MyObj obj = new MyObj();
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			obj.myPrint();
		}
	}
}

public class Thread_sync_prac {
	public static void main(String[] args) {
		ThreadPrac r = new ThreadPrac();
		Thread t1 = new Thread(r, "Thread 1");
		Thread t2 = new Thread(r, "Thread 2");
		
		t1.start();
		t2.start();
	}
}
