package thread_0714;

import javax.swing.JOptionPane;

class ThreadEx_04 extends Thread {
	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()) {
			System.out.println(--i);
//			for(long k = 0; k < 2500000000L; k++); // 시간지연
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				interrupt();
			}
		}
		System.out.println("카운트가 종료됨");
	}
}


public class Thread_method_interrupt {
	public static void main(String[] args) {
		Thread t = new ThreadEx_04();
		
		t.start();
		
		String input = JOptionPane.showInputDialog("값을 입력하세요!");
		System.out.println("입력 값은 : " + input);
		
		t.interrupt();
		// Thread t의 Interrupted state가 true가 됨
		System.out.println("Thread의 상태 값은 : " + t.isInterrupted());
	}
}