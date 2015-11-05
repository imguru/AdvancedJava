package kr.co.ioacademy;

import java.util.Objects;

// 1. Object.equals()�� ���������� ���� ���
// ��� ��ü�� ���� �ڱ� �ڽŰ� �����ϴ�.

// 2. ��ü ���ϼ��� �ƴ� ���� ���ϼ��� ������ �����ϱ� ���ؼ���
// equals()�� �������ؾ� �Ѵ�.

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
    // 1. �ڱ� �ڽ����� �˻� - ����
    if (this == obj) return true;
    // 2. null ���� üũ (��� ��ü�� null�� ��ġ ���谡 ���� �ʴ�.)
    if (obj == null) return false;
    // 3. ������ �ڷ����� ��Ȯ���� �˻�.
    if (!(obj instanceof Point)) return false;
    // 4. �ڷ��� ��ȯ
    Point p = (Point) obj;

    // 5. �߿� �ʵ� ����
    return mX == p.mX && mY == p.mY;
  }
}


class Unit {
  private Point position;
  private Point start;

  // 1. ��ü�� ���� ������ null�� �� �� �ִ�.
  // �ʵ尡 �������� Objects.equal�� �������.(Google Guava / 1.7)


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
