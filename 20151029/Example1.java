package kr.co.ioacademy;

// ��ü�� �����ϴ� ���.
// 1. ������
//  a. ������ �޼ҵ��� �̸��� Ŭ������ �̸��� ����.
//  b. �������� �����ε��� �Ѱ谡 �ִ�.
class RandomIntGenerator {
	final int min;
	final int max;
	
	public RandomIntGenerator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public RandomIntGenerator(int min) {
		this.min = min;
		this.max = Integer.MAX_VALUE;
	}
	
	// 1. ������ ���ڸ� �޴� �ٸ� ������ ��ü ���� ����� ������ �� ����.
	// public RandomIntGenerator(int max) {}
}

public class Example1 {
	public static void main(String[] args) {
		// 2. ��ü�� �����ϴ� �ڵ带 ���ؼ� � ��ü�� �����Ǵ����� ���� �� �� ����.
		RandomIntGenerator obj1 = new RandomIntGenerator(0, 100);
		RandomIntGenerator obj2 = new RandomIntGenerator(0);
	}
}

























