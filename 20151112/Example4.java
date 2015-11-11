package kr.co.ioacademy;

// try-finally 구문은 try 블록을 벗어날 때 finally 블록을 반드시 실행합니다.
// try 블록이 정상적으로 종료되든 비 정상적으로 종료되든 무조건 실행됩니다.

// try 블록의 종료는 무시되고 finally 블록의 종료가 구문 전체의 종료 원인이 됩니다.
// finally 구문 안에서는 절대 return, break, continue 등의 finally 블록을 벗어나면 안된다.
// 예외가 발생하는 일도 없어야 한다.
public class Example13 {
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

// 자바는 3가지 종류의 throwable을 제공한다.
// 1. 점검 지정 예외(checked exception)

// 2. 무점검 지정 예외(unchecked exception)
//  1). 실행 시점 예외(runtime exception)
//  2). 오류(error)

// "API 사용자에게 점검 지정 예외를 준다는 것은 그 상태를 복구할 권한을 준다는 것이다.
//  (무시할 수 있지만 무시하면 안된다.)
// "실행 시점 예외와 오류의 동작 방식은 동일하다. 둘다 catch 할 필요도 없고,
//   처리해서도 안된다. 

// 점검 지정 예외 vs 무점검 지정 예외
// 1. 점검 지정 예외 : 복구가 가능한 상황
// 2. 무점검 지정 예외 : 복구가 불가능한 상황
// 3. 사용자 정의 프로그래밍 오류는 실행 시점 예외(runtime exception)을 사용해야 한다.
// 4. 보통 오류(error)는 JVM의 오류를 표현할 때 사용된다. 
//   (Error의 하위 클래스는 만들지 않는다.)



