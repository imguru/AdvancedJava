package kr.co.ioacademy;


class Image {

  public void release() {
    System.out.println("Image �ڿ� ����");
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

  // ���� Ŭ������ �θ� Ŭ������ finalize()�� �ش� ������
  // �����ϴ� ���. - (������ ��ȣ ����)Finalizer Guardian Idiom
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
    // �ؾ���.!!!
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
