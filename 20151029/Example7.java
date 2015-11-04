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

	// 위의 지연된 초기화는 스레드 안전성이 없습니다.
	// 해결해야 합니다.
	// 1. 엄격한 동기화
	// public synchronized static Cursor getInstance() {
	// if (instance == null)
	// instance = new Cursor();
	//
	// return instance;
	// }

	// 2. 위의 코드는 계속 동기화를 수행하기 때문에 느립니다.
	// 생성 시점에만 동기화를 적용하고, 생성 이후에는 동기화를 제거하는 방법.
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
	// 클래스가 최초로 초기화 되는 시점
	// 1) 클래스 T의 인스턴스가 생성될 때
	// 2) 클래스 T의 정적 메소드가 호출되었을 때
	// 3) 클래스 T의 정적 필드에 값이 할당 되었을 때     *
	// 4) 클래스 T의 정적 필드가 상수 필드가 아니고 사용되었을 때  *
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
