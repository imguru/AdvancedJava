
import java.lang.reflect.Field;

// 객체의 필드를 읽거나 쓰는 방법.
public class Example2 {
  public static void main(String[] args) throws Exception {
    Point point = new Point();

    Class pointClass = point.getClass();

    // public field read / write
    Field xField = pointClass.getField("x");
    Field yField = pointClass.getField("y");

    System.out.println(xField.get(point) + ", " + yField.get(point));

    xField.setInt(point, 10);
    // xField.set(point, 10);
    yField.set(point, 20);
    System.out.println(xField.get(point) + ", " + yField.get(point));

    Field[] fields = pointClass.getDeclaredFields();
    for (Field f : fields)
      System.out.println(f.getName());


    // private field read / write
    Field zField = pointClass.getDeclaredField("z");
    zField.setAccessible(true);
    zField.set(point, 100);

    System.out.println(zField.get(point));
  }

}


class Point {
  public int x;
  public int y;

  private int z;
  public int z() {
    return z;
  }
}
