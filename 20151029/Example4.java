package kr.co.ioacademy;

// �̱���(Singleton)
// ���� : �ϳ��� �ν��Ͻ��� �����Ǵ� Ŭ����

// ���� : ��𿡼��� ������ ������� ������ ��ü�� ���� �� �ִ�.
// ���� : �׽�Ʈ ���̼� ����.
//       ��ü�� ��ü���� ���յ��� ��������.

// �ڹٿ��� ���� ���� ����ϴ� �̱����� ����
// -> �ڹ� 5 �̻󿡼��� ������ �������� ����ȴ�.
class Cursor {
	// ��� 1. private ������
	private Cursor() {
	}

	// ��� 2.
	// public static final Cursor INSTANCE1 = new Cursor();

	// private static final Cursor INSTANCE = new Cursor();
	private static final ThreadLocal<Cursor> INSTANCE
		= new ThreadLocal<Cursor>() {
		@Override
		protected Cursor initialValue() {
			return new Cursor();
		}
	};

	public static Cursor getInstance() {
		return INSTANCE.get();
	}
}

public class Example4 {
	public static void main(String[] args) {
		System.out.println(Cursor.getInstance());
		new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println(Cursor.getInstance());
			}
		}).start();
	
	}
}







