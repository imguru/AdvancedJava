package kr.co.ioacademy;

class Engine {}

class Car {
  private Car instance = new Point();
  private static Class<Engine> engineClass = Engine.class;

  private Engine engine = new Engine();
  public Car() {}
}


public class Example12 {
  public static void main(String[] args) {
    Car p = new Car();
  }
}
