package kr.co.ioacademy;

class Engine {}

class Car {
  // 1. 인스턴스 필드가 생성자 호출보다 우선이다.
  private Car instance; // = new Point();
  private static Class<Engine> engineClass = Engine.class;

  // 2. 인스턴스 필드의 초기화에서 발생한 예외는 생성자가 처리해야 한다. 
  // private Engine engine = engineClass.newInstance();
  //  public Car() throws InstantiationException, IllegalAccessException {
  //    instance = this;
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

  public Car() {}
}


public class Example12 {
  public static void main(String[] args) {
    Car p = new Car();
  }
}
