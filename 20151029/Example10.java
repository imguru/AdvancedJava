package kr.co.ioacademy;

// + 연산자에 대한 오버로딩은 문자열만 제공하고 있다.
// : '+' 연산자는 피연산자로 문자열이 있을 때만 문자열 연결 연산을 수행합니다.
//      문자열이 없으면 그냥 덧셈을 수행합니다.
public class Example10 {
	public static void main(String[] args) {
		System.out.print("H" + "A");
		// System.out.print('H' + 'A');
		
		// 문자를 연결하는 방법 1.
		StringBuilder sb = new StringBuilder();
		sb.append('H').append('A');
		
		System.out.print(sb);
		
		// 방법 2.
		System.out.println("" + 'H' + 'A');
		
		// 방법 3.
		System.out.printf("%c%c", 'H', 'A');
	}
}








