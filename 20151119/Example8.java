// 정리
// 1. 오버라이드될 수 있는 메소드를 생성자 내부에서 절대 호출하면 안된다.
//   (private, final)
// 2. 부모의 private 메소드는 하이딩 된다.
//   hiding : 자식이 볼 수 없다.
// 2. final 메소드는 오버라이드 금지
//   자식이 오버라이드하면 컴파일 에러가 발생.

class Unit {
  private String name;
  public Unit() {
    initialize();
  }

  private void initialize() {
    name = "Unit";
  }

  String getName() { return name; }
}
class SCV extends Unit {
  private int level;

  public SCV() {
    initialize();
  }

  void initialize() {
    level = 1;
  }
}

public class Example8 {
  public static void main(String[] args) {
    SCV u = new SCV();
    System.out.println(u.getName());
  }
}
