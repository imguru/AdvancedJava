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

// 객체 복제 하기
// 1. clone() 함수를 오버라이드 한다. (protected -> public)
// : 오버라이딩할 메소드는 부모의 접근 제한자와 같거나 접근하기 더 쉬워야 한다.

// 2. Cloneable 인터페이스를 구현해야 한다.
// : 어떤 객체가 복제를 허용한다는 사실을 알리는데 쓰이는 용도이다.


// 객체가 Cloneable 인터페이스를 구현하고 있으면, Object.clone() 은
// 객체가 가지고 있는 모든 멤버를 복사한다.
class Unit implements Cloneable {
  private String name;
  private int age;

  private Point position;
  // 중요 : 변경 가능 객체에 대한 참조를 가지고 있으면 문제가 발생한다.

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
  // 공변 반환형 : 재정의 메소드의 리턴 타입은 재정의 되는 메소드의
  // 리턴 타입의 하위 클래스가 될 수 있다.(1.5)
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
      // 1. 전체 복사 후
      Unit result = (Unit) super.clone();

      // 2. 변경 가능 객체 복제
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
