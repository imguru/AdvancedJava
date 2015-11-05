package kr.co.ioacademy;

import java.util.Objects;

// 1. Object.equals()를 재정의하지 않을 경우
// 모든 객체는 오직 자기 자신과 동일하다.

// 2. 객체 동일성이 아닌 논리적 동일성의 개념을 제공하기 위해서는
// equals()를 재정의해야 한다.

class Point {
  private int mX;
  private int mY;

  public Point(int x, int y) {
    this.mX = x;
    this.mY = y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + mX;
    result = prime * result + mY;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    // 1. 자기 자신인지 검사 - 성능
    if (this == obj) return true;
    // 2. null 인지 체크 (모든 객체는 null과 동치 관계가 있지 않다.)
    if (obj == null) return false;
    // 3. 인자의 자료형이 정확한지 검사.
    if (!(obj instanceof Point)) return false;
    // 4. 자료형 변환
    Point p = (Point) obj;

    // 5. 중요 필드 점검
    return mX == p.mX && mY == p.mY;
  }
}


class Unit {
  private Point position;
  private Point start;

  // 1. 객체에 대한 참조는 null이 될 수 있다.
  // 필드가 많아지면 Objects.equal을 고려하자.(Google Guava / 1.7)


  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (!(obj instanceof Unit)) return false;

    Unit p = (Unit) obj;
    // if (position == null) {
    // if (p.position != null) return false;
    // } else if (!position.equals(p.position)) return false;
    // return true;

    return Objects.equals(position, p.position) && Objects.equals(start, p.start);
  }
}



public class Example5 {
  public static void main(String[] args) {
    Point p1 = new Point(10, 20);
    Point p2 = new Point(10, 20);

    if (p1.equals(p2)) {
      System.out.println("Same");
    } else {
      System.out.println("Not Same");
    }
  }

}
