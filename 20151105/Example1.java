package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

// �ٽ� : ��ü ���ο��� �� �޸� �ڿ��� ����Ѵٸ� ����� ���� �޼ҵ带 �����ؾ� �Ѵ�.
// ����
// 1. ������ �÷����� �޸𸮸� �����Ѵ�.
// 2. ������ �÷����� �������� �ʴ� �� �޸� �ڿ��� ���ؼ���
// ���α׷��Ӱ� ���� �ؾ� �Ѵ�.

// 3. finalize() - ������
// ���� : �� �̻� ������ �� ���� ��ü�� �޸� ������ ȸ�� �� �� GC�� ���ؼ� ȣ��Ǵ� �޼ҵ�
// ���� : finalize()�� �� �޸� �ڿ��� �����ϴ� �뵵�� ����ϸ� �ȵȴ�.
// 1. ��� ����ȴٴ� ������ ����.
// ��) ������ �ȿ��� ���� �ݱ�. - JVM�� �����ڸ� õõ�� �����ϹǷ�,
// ���� ������ ������ ���� ���� ���� �� �ִ�.
// �ѹ��� �� �� �ִ� ������ ������ ������ �����Ƿ� ������ �� �� �ִ�.
// - �������� ���� ������ JVM�� ������ �����Ѵ�.

// 2. �ݵ�� ����ȴٴ� ���嵵 ����.
// - �ڹ� ������ �����ڰ� ��� ����Ǿ�� �Ѵٴ� ������ ������,
// �����ڰ� �ݵ�� ����Ǿ�� �Ѵٴ� ������ ����.
// �� �����ڰ� ������� ���� ��ü�� ���� ���·� ���α׷��� ������ ���� �ִ�.
// (����ȭ ��ü ���� ���� ���� �����ڸ� ���� �ݳ��ϸ� �ȵȴ�)


class WebPhoto {
  Image image;

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


public class Example1 {
  public static void main(String[] args) throws InterruptedException {
    // WebPhoto�� �� �̻� ������ �ʴ´ٸ�, ��ü ���ο��� ����ϰ� �ִ�
    // �ڿ��� ���ؼ� ������ �ʿ��ϴ�.
    WebPhoto photo = new WebPhoto("http://d.pr/i/1a8zn+");

    // photo = null;
    // photo.release();

    // System.gc();
  }
}
