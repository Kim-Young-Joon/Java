package stream_0715;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// notepad를 만들어 보자
// JavaFX를 이용
public class MyNotepad extends Application {
	
	TextArea textarea;
	Button openBtn, saveBtn;
	File file;
	
	private void printMsg(String msg) {
		// Runnable interface 를 구현한 객체를 넣어주면 자동으로 동기화 처리
		Platform.runLater(() -> {	
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면을 구성하는 전체 판
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // BorderPane의 가로 세로 길이
		
		// TextArea 생성
		textarea = new TextArea();
		root.setCenter(textarea);
		
		// Button 생성
		openBtn = new Button("파일 열기");
		openBtn.setPrefSize(150, 40);
		openBtn.setOnAction(e -> {
			// 오픈할 파일을 찾아서 그 내용을 textarea에 출력
			textarea.clear(); // textarea의 내용을 다 지움! 새로운 내용을 넣어야 하기 때문
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("오픈할 파일을 선택해 주세요!");
			file = fileChooser.showOpenDialog(primaryStage); 
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while((line = br.readLine()) != null) {
					printMsg(line);
				}
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		
		saveBtn = new Button("파일 저장");
		saveBtn.setPrefSize(150, 40);
		
		saveBtn.setOnAction(e -> {
			String text = textarea.getText();
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(text);
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER); // 가운데 정렬
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10); // 간격
		
		// flowPane에 버튼을 붙임
		flowPane.getChildren().add(openBtn);
		flowPane.getChildren().add(saveBtn);
		
		root.setBottom(flowPane);
		
		// Scene(화면) 객체 생성
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("메모장");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
}