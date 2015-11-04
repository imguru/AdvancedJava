package kr.co.ioacademy;

// 2. ��ü�� �����ϴ� ��� 2. 
//  : ���� ���丮 �޼ҵ�(static factory method)
//   ���� : ��ü�� ������ �� �����ڰ� �ƴ� ���� �޼ҵ带 ���� ��������.

//  ����
//  1. ����� ���� ��� ������ �Ұ����ϴ�. (�׽�Ʈ�� �����)
//  2. �̸��� �� ����� �Ѵ�. 

class RandomIntGenerator {
	final int min;
	final int max;

	// private �̹Ƿ� �ܺο��� ������ �Ұ����ϴ�.
	private RandomIntGenerator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	// ��ü�� �����ϴ� �پ��� ���� �޼ҵ带 ��������.
	// ���� 1. ���� ���丮 �޼ҵ�� �ᱹ �޼ҵ� �̹Ƿ� �̸��� ������ ����.
	public static RandomIntGenerator between(int min, int max) {
		return new RandomIntGenerator(min, max);
	}

	public static RandomIntGenerator biggerThan(int min) {
		return new RandomIntGenerator(min, Integer.MAX_VALUE);
	}

	public static RandomIntGenerator smallerThan(int max) {
		return new RandomIntGenerator(Integer.MIN_VALUE, max);
	}

	// ���� 3. ������ó�� �Ź� ������ �ʿ䰡 ����.
	// Integer.valueOf(3), Long.valueOf(3)
	private static final RandomIntGenerator INSTANCE 
	 = new RandomIntGenerator(Integer.MIN_VALUE, Integer.MAX_VALUE);
	public static RandomIntGenerator getInstance() {
		return INSTANCE;
	}
}

public class Example2 {
	public static void main(String[] args) {
		// ���� 2. ���̺귯�� ����ڵ��� ��ü�� � ��å�� ������ �����Ǵ���
		// �̸��� ���� ���� ������ �� �ִ�.
		RandomIntGenerator obj1 = RandomIntGenerator.between(0, 100);
		RandomIntGenerator obj2 = RandomIntGenerator.smallerThan(100);
		RandomIntGenerator obj3 = RandomIntGenerator.biggerThan(0);
	}
}
