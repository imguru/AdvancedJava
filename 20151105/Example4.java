package kr.co.ioacademy;


class Image {

  public void release() {
    System.out.println("Image 자원 해지");
  }

//  @Override
//  protected void finalize() throws Throwable {
//    try {
//      System.out.println("Image finalize!");
//      release();
//    } finally {
//      super.finalize();
//    }
//  }

  // 하위 클래스가 부모 클래스의 finalize()를 잊는 문제를
  // 방지하는 방법. - (종료자 보호 패턴)Finalizer Guardian Idiom
  @SuppressWarnings("unused")
  private final Object guardian = new Object() {
    @Override
    protected void finalize() throws Throwable {
      release();
    }
  };
}


class MyImage extends Image {

  @Override
  protected void finalize() throws Throwable {
    System.out.println("MyImage finalize!");
    // 잊었다.!!!
    // super.finalize();
  }
}


public class Example4 {
  public static void main(String[] args) throws InterruptedException {
    MyImage image = new MyImage();
    image = null;

    System.gc();

    Thread.sleep(10000);
  }
}
