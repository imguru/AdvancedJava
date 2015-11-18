class Unit {
  private String name;
  public Unit() {
    initialize();
  }

  void initialize() {
    name = "Unit";
  }

  public String name() {
    return name;
  }
}

class SCV extends Unit {
  private int level;

  public int level() {
    return level;
  }

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
    System.out.println(u.level());
    System.out.println(u.name());
  }
}
