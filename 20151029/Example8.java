package kr.co.ioacademy;

import java.util.Calendar;

// ���� �ʵ�� ���������� �Ʒ��� �������� �ʱ�ȭ �մϴ�.
// ����ϱ� ���� �ʱ�ȭ �� �� �ֵ��� �տ� ��ġ�ؾ� �մϴ�.
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





