package kr.co.ioacademy;

class Cursor {
	// private static Cursor instance = null;

	private Cursor() {
		System.out.println("Cursor");
	};

	// public static Cursor getInstance() {
	// if (instance == null)
	// instance = new Cursor();
	//
	// return instance;
	// }

	// ���� ������ �ʱ�ȭ�� ������ �������� �����ϴ�.
	// �ذ��ؾ� �մϴ�.
	// 1. ������ ����ȭ
	// public synchronized static Cursor getInstance() {
	// if (instance == null)
	// instance = new Cursor();
	//
	// return instance;
	// }

	// 2. ���� �ڵ�� ��� ����ȭ�� �����ϱ� ������ �����ϴ�.
	// ���� �������� ����ȭ�� �����ϰ�, ���� ���Ŀ��� ����ȭ�� �����ϴ� ���.
	// DCLP(Double Checked Locking Pattern)
//	public static Cursor getInstance() {
//		if (instance == null) {
//			synchronized (Cursor.class) {
//				if (instance == null)
//					instance = new Cursor();
//			}
//		}
//		return instance;
//	}

	// 3. IODH(Initialization On Demand Holder)
	// Ŭ������ ���ʷ� �ʱ�ȭ �Ǵ� ����
	// 1) Ŭ���� T�� �ν��Ͻ��� ������ ��
	// 2) Ŭ���� T�� ���� �޼ҵ尡 ȣ��Ǿ��� ��
	// 3) Ŭ���� T�� ���� �ʵ忡 ���� �Ҵ� �Ǿ��� ��     *
	// 4) Ŭ���� T�� ���� �ʵ尡 ��� �ʵ尡 �ƴϰ� ���Ǿ��� ��  *
	private static class Singleton {
		private static final Cursor INSTANCE = new Cursor();
	}
	
	public static Cursor getInstance() {
		return Singleton.INSTANCE;
	}
		
	public static void foo() {
		System.out.println("foo");
	}
}

public class Example7 {
	public static void main(String[] args) {
		Cursor.foo();
		Cursor.getInstance();
	}
}
