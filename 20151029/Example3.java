package kr.co.ioacademy;

import org.junit.Test;

public class Example3 {
	public static void main(String[] args) {

		// 불필요한 객체가 생성된다.
		String s1 = new String("hello");

		String s2 = "hello";
		// 같은 가상 머신에서 실행되는 모든 코드가 해당 객체를 재사용한다.

		Boolean b1 = new Boolean(true);
		Boolean b2 = Boolean.TRUE;
	}

	@Test
	public void testLong2() {
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; ++i)
			sum += i;
		
		System.out.println(sum);
	}
	
	@Test
	public void testLong() {
		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; ++i)
			sum += i;
		
		System.out.println(sum);
	}

}
