package kr.co.ioacademy;

class Engine {}

class Car {
  // 1. �ν��Ͻ� �ʵ尡 ������ ȣ�⺸�� �켱�̴�.
  private Car instance; // = new Point();
  private static Class<Engine> engineClass = Engine.class;

  // 2. �ν��Ͻ� �ʵ��� �ʱ�ȭ���� �߻��� ���ܴ� �����ڰ� ó���ؾ� �Ѵ�. 
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
