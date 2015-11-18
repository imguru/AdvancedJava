package kr.co.ioacademy;

// Java 의 클래스 = 레퍼런스 타입
// : 객체는 힙에 생성된다.

// Immutable Object(불변 객체)
// 장점
// 1. 생성자의 방어 복사 및 접근 메소드의 방어 복사가 필요없다.
// 2. 병렬 프로그래밍을 작성할 때, 동기화 없이 객체를 공유 가능하다.
//   "특별한 이유가 없다면 객체를 불변 객체로 설계해야 한다."
//    : Effective Java, Effective Objective-C
// http://d.pr/n/13A75

// 단점
// 객체가 가지는 값마다 새로운 객체가 필요하다.
// String s += "xxx";   // "Helloxxx"
//  : 내용이 동일한 객체는 공유되는 메커니즘을 제공해야 한다.(Flyweight)
//    - static factory method

// 불변 클래스를 만드는 방법
// 1. 객체를 변경하는 setter 를 제공하지 않습니다.
// 2. 모든 필드를 final
// 3. 가변 객체 참조 필드를 사용자가 얻을 수 없도록 해야 한다
// 4. 상속 금지

public class Example1 {
    public static void main(String[] args) {
        Point pos = new Point(10, 20);

        // Integer i;

        Rect r = new Rect(pos);
        // pos.setY(100);    // 공격!

        pos = r.getPosition();
        // pos.setX(-9999);

        String s = r.getName();
        s = "xxx";

        System.out.println(r);
    }
}

// String, Integer, Long ... : Immutable Object

class Rect {
    // 캡슐화, 정보 은닉
    private final Point position;
    private String name;

    public Rect(Point position) {
        this.position = position.clone();
        this.name = "Tom";
    }

    public String getName() {
        return name;
    }

    public Point getPosition() {
        return position.clone();
    }

    @Override
    public String toString() {
        return "Rect{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}


class Point implements Cloneable {
    final int x;
    final int y;

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /*
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    */

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}