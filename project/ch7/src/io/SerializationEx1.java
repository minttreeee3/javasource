package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/*	직렬화(Serialization)
객체를 데이터 스트림으로 만드는 것
=> 객체에 저장된 데이터를 스트림에 쓰기 위해 연속적인 데이터로 변환

역직렬화(deserialization)
스트림으로부터 데이터를 읽어서 객체를 만드는 것
		
		
*/	
	
	
public class SerializationEx1 {	
	public static void main(String[] args) {
		
		Person p1 = new Person("김유신", "엔지니어");
		Person p2 = new Person("이순신", "선생님");
		
		
		// ObjectOutputStream : 스트림에 객체를 출력. 객체를 사용할땐 항상 이걸 사용 
		
		try (FileOutputStream fos = new FileOutputStream("c:\\temp\\serial.dat");
			 BufferedOutputStream bos = new BufferedOutputStream(fos);	
			 ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			
			oos.writeObject(p1);
			oos.writeObject(p2);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		// 직렬화된 객채 => 역직렬화(ObjectInputStream)
		
		try (FileInputStream ios = new FileInputStream("c:\\temp\\serial.dat");
			 BufferedInputStream bis = new BufferedInputStream(ios);	
			 ObjectInputStream ois = new ObjectInputStream(bis)) {
				
				for (int i = 0; i < 2; i++) {
					Person p = (Person) ois.readObject();
					System.out.println(p);
				}			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
