package kr.co.ioacademy;

// �ڹ��� �̱����� ��ü�� Ŭ���� �δ��� ���� �ε��� �� �����ȴ�.
// : ��ü�� ���� ����� ũ�ų�, ��ü�� ������� ���� ��� ���ҽ� ���� ���ϴ�.
//  (�̱����� ������ �÷����� ����� �ƴϴ�.)

// ������ �ʱ�ȭ�� �ʿ伺
// 1. �޸� ���� ����
// 2. ���ø����̼��� �ε� �ӵ� ����

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
