
// 이항 숫자 확산
// 결론 : 조건 연산자를 사용할 때는 두번째와 세번째 피연산자의 타입을
//       일치시켜야 한다.

public class Example11 {
  public static void main(String[] args) {
    char x = 'X';
    final int i = 0;

    System.out.println(true ? x : 0);
    System.out.println(false ? i : x);
  }
}
