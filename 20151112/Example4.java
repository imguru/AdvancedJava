package kr.co.ioacademy;

public class Example4{
  public static void main(String[] args) {
    System.out.println(result());
  }

  static boolean result() {
    try {
      return true;
    } finally {
      return false;
    }
  }
}



