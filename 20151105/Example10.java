package kr.co.ioacademy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

final class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Integer[] values() { return VALUES; }
  private static final Integer[] VALUES = {1, 2, 3, 4, 5};
  
  public int x() {
    return x;
  }

  public int y() {
    return y;
  }
}


public class Example10 {
  public static void main(String[] args) {
    Point.values()[0] = 50;
    System.out.println(Point.values()[0]);
  }
}
