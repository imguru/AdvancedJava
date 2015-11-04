package kr.co.ioacademy;

// 객체를 생성하는 방법.
// 1. 생성자
//  a. 생성자 메소드의 이름은 클래스의 이름과 같다.
//  b. 생성자의 오버로딩은 한계가 있다.
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
	
	// 1. 동일한 인자를 받는 다른 형태의 객체 생성 방법을 제공할 수 없다.
	// public RandomIntGenerator(int max) {}
}

public class Example1 {
	public static void main(String[] args) {
		// 2. 객체를 생성하는 코드를 통해서 어떤 객체가 생성되는지를 절대 알 수 없다.
		RandomIntGenerator obj1 = new RandomIntGenerator(0, 100);
		RandomIntGenerator obj2 = new RandomIntGenerator(0);
	}
}

























