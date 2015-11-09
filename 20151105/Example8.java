package kr.co.ioacademy;

import com.google.common.base.MoreObjects;

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

// ��ü ���� �ϱ�
// 1. clone() �Լ��� �������̵� �Ѵ�. (protected -> public)
// : �������̵��� �޼ҵ�� �θ��� ���� �����ڿ� ���ų� �����ϱ� �� ������ �Ѵ�.

// 2. Cloneable �������̽��� �����ؾ� �Ѵ�.
// : � ��ü�� ������ ����Ѵٴ� ����� �˸��µ� ���̴� �뵵�̴�.


// ��ü�� Cloneable �������̽��� �����ϰ� ������, Object.clone() ��
// ��ü�� ������ �ִ� ��� ����� �����Ѵ�.
class Unit implements Cloneable {
  private String name;
  private int age;

  private Point position;
  // �߿� : ���� ���� ��ü�� ���� ������ ������ ������ ������ �߻��Ѵ�.

  public Unit(String name, int age, Point pos) {
    this.name = name;
    this.age = age;
    this.position = pos;
  }

  public void setPos(int x, int y) {
    position.setX(x);
    position.setY(y);
  }

  
  // public Object clone() {
  // ���� ��ȯ�� : ������ �޼ҵ��� ���� Ÿ���� ������ �Ǵ� �޼ҵ���
  // ���� Ÿ���� ���� Ŭ������ �� �� �ִ�.(1.5)
  //  @Override
  //  public Unit clone() {
  //    try {
  //      return (Unit) super.clone();
  //    } catch (CloneNotSupportedException e) {
  //      e.printStackTrace();
  //    }
  //
  //    return null;
  //  }

  @Override
  public Unit clone() {
    try {
      // 1. ��ü ���� ��
      Unit result = (Unit) super.clone();

      // 2. ���� ���� ��ü ����
      result.position = position.clone();
      return result;

    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).add("age", age)
        .add("pos", position).toString();
  }
}


public class Example8 {
  public static void main(String[] args) {
    Unit p1 = new Unit("Tom", 42, new Point(0, 0));

    // Unit p2 = (Unit) p.clone();
    Unit p2 = p1.clone();

    p2.setPos(10, 20); // !!!

    System.out.println(p1);
    System.out.println(p2);
  }
}
