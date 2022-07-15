package thread_0715;

// Thread에 의해서 공유되는 공유객체를 생성하기 위한 class
class Account {
	private int balance = 1000; // 계좌 잔액
	
	public int getBalance() {
		return balance;
	}
	
	// 출금하는 method -> 동기화 처리
	public void withdraw(int money) {
		synchronized (this) {
			if(balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) { }
				
				balance -= money;
			}
		}
	}
}

class ThreadEx_09 implements Runnable {
	// 공용객체
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("잔액 : " + acc.getBalance());
		}
	}
}

public class Thread_sync {
	public static void main(String[] args) {
		// Runnable 객체
		ThreadEx_09 r = new ThreadEx_09();
		
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		
		t1.start();
		t2.start();
		
	}
}