package kr.co.ioacademy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

import org.junit.Test;

// �Ʒ��� �̱����� �� ���� ��쿡 ��ü�� �ΰ��̻� ������ �� �ֽ��ϴ�.
// 1. Reflection
// 2. ����ȭ
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

// ���� �������� �ذ��ϱ� ���� ���Ӱ� ���ȵ� �̱���
//  ���Ұ� �ϳ����� enum �� �̿�����.
// ���÷����� ���� �����ϴ� �͵� �ϴ� �� �Ұ����ϰ�
// ����ȭ�� ���� ��ü ������ �ڵ������� ó�����ش�.
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





