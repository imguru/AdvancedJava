package kr.co.ioacademy;

// + �����ڿ� ���� �����ε��� ���ڿ��� �����ϰ� �ִ�.
// : '+' �����ڴ� �ǿ����ڷ� ���ڿ��� ���� ���� ���ڿ� ���� ������ �����մϴ�.
//      ���ڿ��� ������ �׳� ������ �����մϴ�.
public class Example10 {
	public static void main(String[] args) {
		System.out.print("H" + "A");
		// System.out.print('H' + 'A');
		
		// ���ڸ� �����ϴ� ��� 1.
		StringBuilder sb = new StringBuilder();
		sb.append('H').append('A');
		
		System.out.print(sb);
		
		// ��� 2.
		System.out.println("" + 'H' + 'A');
		
		// ��� 3.
		System.out.printf("%c%c", 'H', 'A');
	}
}








