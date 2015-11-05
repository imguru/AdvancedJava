package kr.co.ioacademy;


class Image {
  public void release() {
    System.out.println("Image 자원 해지");
  }

 @Override
 protected void finalize() throws Throwable {
   try {
     System.out.println("Image finalize!");
     release();
   } finally {
     super.finalize();
   }
 }
}


class MyImage extends Image {

  @Override
  protected void finalize() throws Throwable {
    System.out.println("MyImage finalize!");
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
