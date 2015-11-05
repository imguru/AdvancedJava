package kr.co.ioacademy;

import com.google.common.base.MoreObjects;

public class Example9 {
  public static void main(String[] args) {
    Point pos = new Point(100, 200);
    String name = "Tom";
    Unit unit = new Unit(pos, name);

    pos.setX(9999);
    pos = unit.position();
    pos.setX(9999);

    System.out.println(unit);
  }
}

class Unit {
  private Point position;
  private String name;

  public Unit(Point pos, String name) {
    position = pos.clone();

    this.name = name;
  }

  public String name() {
    return name;
  }

  public Point position() {
    return position.clone();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
           .add("pos", position).add("name", name).toString();
  }

}


class Point implements Cloneable {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public Point clone() {
    try {
      return (Point) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    return null;
  }
}
