package kr.co.ioacademy;

// 자바의 싱글톤은 객체가 클래스 로더에 의해 로딩될 때 생성된다.
// : 객체의 생성 비용이 크거나, 객체를 사용하지 않을 경우 리소스 낭비가 심하다.
//  (싱글톤은 가비지 컬렉션의 대상이 아니다.)

// 지연된 초기화의 필요성
// 1. 메모리 낭비 제거
// 2. 애플리케이션의 로딩 속도 개선

class Cursor {
	public static final Cursor INSTANCE = new Cursor();
	private Cursor() {
		System.out.println("Cursor created!");;
	}
	
	public static void foo() {
		System.out.println("foo");;
	}
}

public class Example6 {
	public static void main(String[] args) {
		Cursor.foo();
	}
}
