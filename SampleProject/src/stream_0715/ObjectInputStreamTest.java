package stream_0715;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class ObjectInputStreamTest {

	public static void main(String[] args) {
		File file = new File("/Users/youngjoon/Desktop/readme.txt");
		
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// 어떤 객체가 있을지 모르기 때문에 Object type 으로 오게 된다.
			// 따라서 Object type 으로 받음
			Object obj = ois.readObject();
			
			// 원래는 여기서 전달받은 데이터가 어떤 객체인지 확인해야 함
			
			Map<String, String> map = (Map<String, String>) obj;
			System.out.println(map.get("2"));
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
