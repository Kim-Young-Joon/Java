package stream_0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
	
	
	public static void main(String[] args) {
		System.out.println("키보드로 한 줄을 입력하세요!");
		
		// 키보드(표준입력 - System.in)를 통해 데이터를 1줄 입력 받을 것이다.
		// 이 System.in 이라는 제공된 Stream은 사용하기 너무 힘듦
		// System.in 을 확장해서 InputStreamReader를 사용
		InputStreamReader isr = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String input = br.readLine();
			System.out.println("입력받은 문자열은 : " + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
