package kr.co.ioacademy;

class Unit {
  private String name = null;

  public String name() {
    return name;
  }

  protected void initialize() {
    name = "Unit";
  }

  public Unit() {
    initialize();
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

  protected void initialize() {
    level = 1;
  }
}

public class Example11 {
  public static void main(String[] args) {
    SCV u = new SCV();
    System.out.println(u.level());
    System.out.println(u.name());
  }
}
