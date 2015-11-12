package kr.co.ioacademy;

class Engine {}

class Car {
  private Car instance; // = new Point();
  private static Class<Engine> engineClass = Engine.class;

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


public class Example3 {
  public static void main(String[] args) {
    Car p = new Car();
  }
}
