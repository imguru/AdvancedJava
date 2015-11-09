package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

// finalize()의 용도
// : 명시적 종료 메소드 호출을 잊은 경우의 안정망을 제공할 수 있다.

// 1. 그런 자원을 발견한 경우 반드시 경고 메세지를 남겨야 한다. (클라이언트 코드에 버그가 있는 것이므로)
// 2. 부모의 종료자를 명시적으로 호출해야 한다.

class WebPhoto {
  Image image;

  /*
  @Override
  public void finalize() {
    if (image != null) {
      System.err.println("Explicit termination method 'release' is not called");
      release();
    }
  }
  */
  
  @Override
  public void finalize() throws Throwable {
    try {
      if (image != null) {
        System.err.println("Explicit termination method 'release' is not called");
        release();
      }
    } finally {
      super.finalize();
    }
  }
  
  // 명시적인 종료 메소드 - OutputStream, InputStream, Socket 등
  public void release() {
    if (image != null) {
      image.flush();
    }
  }

  public WebPhoto(String imageUrl) {
    URL url;
    try {
      url = new URL(imageUrl);
      image = ImageIO.read(url);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


public class Example2 {
  public static void main(String[] args) throws InterruptedException {
    WebPhoto photo = new WebPhoto("http://d.pr/i/1a8zn+");
    // System.gc();
  }
}
