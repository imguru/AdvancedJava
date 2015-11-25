// finally
// try 블록을 벗어날 때 무조건 수행되는 것이 보장된다.
// -> finally 구문 안에서는 절대 흐름 제어 문법을 사용하면 안된다.
//    return, break, continue
// -> 예외가 발생해도 안된다.

public class Example10 {
  public static void main(String[] args) {
    System.out.println(result());
  }

  static boolean result() {
    try {
      return true;
    } finally {
      return false;
    }
  }
}
