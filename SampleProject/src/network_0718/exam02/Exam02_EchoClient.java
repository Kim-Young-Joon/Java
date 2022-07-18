package network_0718.exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {
	TextArea textarea;
	Button connBtn;
	TextField idField, textfield;
	
	Socket socket;
	BufferedReader br;
	PrintWriter pr;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // 화면 center에 textarea를 붙임
		
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40); // 버튼 크기
		connBtn.setOnAction(e -> {
			textarea.clear();
			try {
				socket = new Socket("localhost", 5678);
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pr = new PrintWriter(socket.getOutputStream());
				textarea.appendText("Echo 서버 접속 성공!\n");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		});
		
		idField = new TextField();
		idField.setPrefSize(100, 40);
		
		textfield = new TextField();
		textfield.setPrefSize(200, 40);
		textfield.setOnAction(e -> {
			String msg = idField.getText() + " : " + textfield.getText();
			pr.println(msg);
			pr.flush();
			
			if(textfield.getText().equals("/exit")) {
				textarea.appendText("Echo 서버 연결을 종료합니다.\n");
				textfield.setDisable(true);
			} else {
				try {
					String serverMsg = br.readLine();
					textarea.appendText(serverMsg + "\n");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			textfield.clear();
			
		}); // 입력상자에 글 입력 후 enter 입력하면 이벤트 처리
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // 여백 주기
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn);
		flowPane.getChildren().add(idField);
		flowPane.getChildren().add(textfield); 
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
