package kr.co.ioacademy;

import org.junit.Test;

public class Example3 {
	public static void main(String[] args) {

		// ���ʿ��� ��ü�� �����ȴ�.
		String s1 = new String("hello");

		String s2 = "hello";
		// ���� ���� �ӽſ��� ����Ǵ� ��� �ڵ尡 �ش� ��ü�� �����Ѵ�.

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
