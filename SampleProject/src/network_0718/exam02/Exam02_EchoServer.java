package network_0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exam02_EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter pr = null;
		BufferedReader br = null;
		
		try {
			serverSocket = new ServerSocket(5678);
			System.out.println("Echo Server 기동 - 클라이언트 접속 대기");
			// accept 호출 이후부터 Client의 요청을 받을 수 있음
			socket = serverSocket.accept(); // blocking
			// 접속 성공
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pr = new PrintWriter(socket.getOutputStream());
			
			String msg = null;
			
			while(true) {
				msg = br.readLine();
				if(msg.equals("/exit") || msg == null) {
					break;
				}
				pr.println(msg);
				pr.flush();
				
			}
			
		} catch (Exception e) {
			
		} finally {
			// 사용된 resource 해제
			// 해당 객체가 존재하지 않는 상태에서 close 하려고 하면 nullpointexception 발생할 수 있음
			try {
				if(br != null) br.close();
				if(pr != null) pr.close();
				if(socket != null) socket.close();
				if(serverSocket != null) serverSocket.close();
				System.out.println("Echo Server 종료!!");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
