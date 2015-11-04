package kr.co.ioacademy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

import org.junit.Test;

// 아래의 싱글톤은 두 가지 경우에 객체가 두개이상 생성될 수 있습니다.
// 1. Reflection
// 2. 직렬화
//class Cursor implements Serializable {
//	private Cursor() {
//	}
//	
//	private Object readResolve() {
//		return INSTANCE;
//	}
//	
//	private static final Cursor INSTANCE = new Cursor();
//
//	public static Cursor getInstance() {
//		return INSTANCE;
//	}
//}

// 위의 문제점을 해결하기 위해 새롭게 제안된 싱글톤
//  원소가 하나뿐인 enum 을 이용하자.
// 리플렉션을 통해 생성하는 것도 하는 것 불가능하고
// 직렬화에 의한 객체 생성도 자동적으로 처리해준다.
enum Cursor {
	INSTANCE;
	
	public static Cursor getInstance() {
		return INSTANCE;
	}
}

public class Example5 {
	@Test
	public void Serialize() throws Exception {
		String filename = "cursor.dat";
		
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Cursor.getInstance());
		
		fos.close();
		oos.close();
		
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Cursor c = (Cursor) ois.readObject();
		
		System.out.println(c);
		System.out.println(Cursor.getInstance());
	}
	
	
	@Test
	public void Refelction() throws Exception {
		Constructor<?> con = Cursor.class.getDeclaredConstructors()[0];
		con.setAccessible(true);

		Cursor c = (Cursor) con.newInstance();

		System.out.println(c);
		System.out.println(Cursor.getInstance());
	}

}





