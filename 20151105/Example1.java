package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

// 핵심 : 객체 내부에서 비 메모리 자원을 사용한다면 명시적 종료 메소드를 제공해야 한다.
// 이유
// 1. 가비지 컬렉션은 메모리만 수집한다.
// 2. 가비지 컬렉션이 수거하지 않는 비 메모리 자원에 대해서는
// 프로그래머가 관리 해야 한다.

// 3. finalize() - 종료자
// 개념 : 더 이상 참조할 수 없는 객체의 메모리 공간을 회수 할 때 GC에 의해서 호출되는 메소드
// 문제 : finalize()를 비 메모리 자원을 정리하는 용도로 사용하면 안된다.
// 1. 즉시 실행된다는 보장이 없다.
// 예) 종료자 안에서 파일 닫기. - JVM은 종료자를 천천히 실행하므로,
// 열린 상태의 파일이 많이 남아 있을 수 있다.
// 한번에 열 수 있는 파일의 개수에 제한이 있으므로 오류가 날 수 있다.
// - 종료자의 실행 시점은 JVM의 구현에 의존한다.

// 2. 반드시 실행된다는 보장도 없다.
// - 자바 명세에는 종료자가 즉시 실행되어야 한다는 문구도 없지만,
// 종료자가 반드시 실행되어야 한다는 문구도 없다.
// 즉 종료자가 실행되지 않은 객체가 남은 상태로 프로그램이 종료할 수도 있다.
// (동기화 객체 같은 것을 절대 종료자를 통해 반납하면 안된다)


class WebPhoto {
  Image image;

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


public class Example1 {
  public static void main(String[] args) throws InterruptedException {
    // WebPhoto가 더 이상 사용되지 않는다면, 객체 내부에서 사용하고 있는
    // 자원에 대해서 정리가 필요하다.
    WebPhoto photo = new WebPhoto("http://d.pr/i/1a8zn+");

    // photo = null;
    // photo.release();

    // System.gc();
  }
}
