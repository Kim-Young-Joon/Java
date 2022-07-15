package stream_0715;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectStreamTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "홍길동");
		map.put("2", "아이유");
		map.put("3", "김연아");
		
		// primitive type으로만 저장하는 것이 아니라
		// 객체 형태 그대로 파일에 저장가능 -> Object Stream 
		
		File file = new File("/Users/youngjoon/Desktop/readme.txt");
		FileOutputStream fos;
		
		try {
			// file이 없으면 새로 만들게 된다.
			// FileOutputStream은 객체를 전달할 수 없음 (primitive type의 data만 가능)
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Stream 결합
			oos.writeObject(map);
			
			// 닫는 순서의 원칙은 나중에 만든 것을 먼저 닫는 것이다.
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}
