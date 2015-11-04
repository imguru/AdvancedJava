package kr.co.ioacademy;

// int, long, byte : signed
// char : unsigned

// 변환되는 자료형에 상관없이 원래 부호가 있는 타입이면 부호 확장이 일어나고, char 자료형이면
// 0의 확장이 일어난다.

public class Example11 {
	public static void main(String[] args) {
		System.out.println((int)(char)(byte)-1);
	}
}
