package kr.co.ioacademy;

import java.util.Calendar;

// 정적 필드는 위에서부터 아래로 차근차근 초기화 합니다.
// 사용하기 전에 초기화 할 수 있도록 앞에 배치해야 합니다.
class Person {
	public static final Person INSTANCE = new Person();
	private final int weight;

	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	private Person() {
		weight = CURRENT_YEAR - 1984;
	}

	public int weight() {
		return weight;
	}
}

public class Example8 {
	public static void main(String[] args) {
		System.out.println(Person.INSTANCE.weight());
		System.out.println(Person.INSTANCE.CURRENT_YEAR);
	}
}





