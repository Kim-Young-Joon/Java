package network_0718.exam01;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Server 쪽 Process
public class Exam01_DateServer {
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(5678);
			System.out.println("Data Server 기동 - 포트번호(5678)");
			// accept 호출 이후부터 Client의 요청을 받을 수 있음
			Socket socket = serverSocket.accept(); // blocking
			// 접속 성공
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			
			// 현재 날짜
			Date date = new Date();
			pr.println(date.toLocaleString());
			// 버퍼 안에 들어가 있는 데이터를 스트림을 통해 내보내는 시점은
			// 1. 스트림이 강제로 종료될 경우 (close)
			// 2. 버퍼에 공간이 다 찰 경우
			
			pr.flush();
			pr.close();
			socket.close();
			serverSocket.close();
			System.out.println("Date Server 종료");
		} catch (Exception e) {
			
		}
	}
}
