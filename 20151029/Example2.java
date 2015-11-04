package kr.co.ioacademy;

// 2. 객체를 생성하는 방법 2. 
//  : 정적 팩토리 메소드(static factory method)
//   정의 : 객체를 생성할 때 생성자가 아닌 정적 메소드를 통해 생성하자.

//  단점
//  1. 상속을 통한 기능 변경이 불가능하다. (테스트가 힘들다)
//  2. 이름을 잘 지어야 한다. 

class RandomIntGenerator {
	final int min;
	final int max;

	// private 이므로 외부에서 접근이 불가능하다.
	private RandomIntGenerator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	// 객체를 생성하는 다양한 정적 메소드를 제공하자.
	// 장점 1. 정적 팩토리 메소드는 결국 메소드 이므로 이름에 제한이 없다.
	public static RandomIntGenerator between(int min, int max) {
		return new RandomIntGenerator(min, max);
	}

	public static RandomIntGenerator biggerThan(int min) {
		return new RandomIntGenerator(min, Integer.MAX_VALUE);
	}

	public static RandomIntGenerator smallerThan(int max) {
		return new RandomIntGenerator(Integer.MIN_VALUE, max);
	}

	// 장점 3. 생성자처럼 매번 생성할 필요가 없다.
	// Integer.valueOf(3), Long.valueOf(3)
	private static final RandomIntGenerator INSTANCE 
	 = new RandomIntGenerator(Integer.MIN_VALUE, Integer.MAX_VALUE);
	public static RandomIntGenerator getInstance() {
		return INSTANCE;
	}
}

public class Example2 {
	public static void main(String[] args) {
		// 장점 2. 라이브러리 사용자들은 객체가 어떤 정책을 가지고 생성되는지
		// 이름을 통해 쉽게 이해할 수 있다.
		RandomIntGenerator obj1 = RandomIntGenerator.between(0, 100);
		RandomIntGenerator obj2 = RandomIntGenerator.smallerThan(100);
		RandomIntGenerator obj3 = RandomIntGenerator.biggerThan(0);
	}
}
