package kr.co.ioacademy;

// 싱글톤(Singleton)
// 개념 : 하나의 인스턴스만 생성되는 클래스

// 장점 : 어디에서든 동일한 방법으로 동일한 객체를 얻을 수 있다.
// 단점 : 테스트 용이성 낮다.
//       객체와 객체간의 결합도가 높아진다.

// 자바에서 가장 많이 사용하는 싱글톤의 형태
// -> 자바 5 이상에서는 스레드 안전성도 보장된다.
class Cursor {
	// 방법 1. private 생성자
	private Cursor() {
	}

	// 방법 2.
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







