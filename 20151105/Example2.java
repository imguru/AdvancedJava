package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

// finalize()�� �뵵
// : ����� ���� �޼ҵ� ȣ���� ���� ����� �������� ������ �� �ִ�.

// 1. �׷� �ڿ��� �߰��� ��� �ݵ�� ��� �޼����� ���ܾ� �Ѵ�. (Ŭ���̾�Ʈ �ڵ忡 ���װ� �ִ� ���̹Ƿ�)
// 2. �θ��� �����ڸ� ��������� ȣ���ؾ� �Ѵ�.

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
  
  // ������� ���� �޼ҵ� - OutputStream, InputStream, Socket ��
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
