
// 자바의 예외 3가지
// 1. 점검 지정 예외     : 복구가 가능한 상황
// 2. 무점검 지정 예외    : 복구가 불가능한 상황
//  1) 실행 시점 예외(Runtime Exception) - 사용자
//  2) 오류(Error) - JVM

// API 사용자에게 점검 지정 예외를 준다는 것은 그 상태를 복구할 권한을 준다는 것이다.
// (무시할 수 있지만 무시하면 안된다)

// 실행 시점 예외와 오류의 동작 방식은 동일하다.
// -> 둘다 catch 할 필요가 없다. 처리해서도 안된다.


class Engine {}

class Car {

  private static Class<Engine> engineClass = Engine.class;
//  private Engine engine = engineClass.newInstance();
//  // 2. 인스턴스 필드의 초기화에서 발생하는 예외는 생성자에서 처리해야 한다.
//  public Car() throws Exception {
//  }

  private Engine engine = newEngine();
  private static Engine newEngine() {
    try {
      return engineClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  /*
  // 1. 인스턴스 필드가 생성자 호출보다 먼저 일어난다.
  private Car instance = new Car();
  public Car() throws Exception {
    throw new Exception("Failed to create");
  }
  */
}

public class Example9 {
  public static void main(String[] args) {
    try {
      Car car = new Car();
      System.out.println("Succeed");
    } catch (Exception e) {
      System.out.println("Failed");
    }
  }
}
