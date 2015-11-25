// Reflection 성능.
// 1. Refelction 은 염려할만큼의 성능 저하는 없다.
// 2. 잘 설계된 Reflection은 객체 지향의 철학을 어긋나지 않으면서,
//    더 좋은 코드를 만들어 낼 수 있다.

public class Example6 {
  public static void doRegular() throws Exception {
    long start = System.currentTimeMillis();

    for (int i = 0; i < 1000000; i++) {
      Point p = new Point();
      p.print();
    }

    System.out.println(System.currentTimeMillis() - start);
  }

  public static void doReflection() throws Exception {
    long start = System.currentTimeMillis();

    Class clazz = Class.forName("Point");
    for (int i = 0; i < 1000000; i++) {
      Point p = (Point) clazz.newInstance();
      p.print();
    }

    System.out.println(System.currentTimeMillis() - start);
  }

  public static void main(String[] args) throws Exception {
    doRegular();
    doReflection();
  }
}

class Point {
  private int x;
  private int y;

  public void print() {
  }
}
