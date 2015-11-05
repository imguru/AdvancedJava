package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

final class CloseGuard {
  public static CloseGuard get() {
    return new CloseGuard();
  }

  private CloseGuard() {}

  private Throwable site;

  public void open(String closer) {
    if (closer == null) throw new NullPointerException("closer == null");

    String message = "Explicit termination method '" + closer + "' not called";
    site = new Throwable(message);
  }

  public void close() {
    site = null;
  }

  public void warnIfOpen() {
    if (site == null) return;

    System.err.println(site.toString());
  }
}


class WebPhoto {
  private Image image;

  private final CloseGuard mCloseGuard = CloseGuard.get();

  @Override
  public void finalize() throws Throwable {
    try {
      if (mCloseGuard != null) mCloseGuard.warnIfOpen();
      release();

    } finally {
      super.finalize();
    }
  }

  public void release() {
    if (image != null) {
      image.flush();
    }

    if (mCloseGuard != null) mCloseGuard.close();
  }

  public WebPhoto(String imageUrl) {
    URL url;
    try {
      url = new URL(imageUrl);
      image = ImageIO.read(url);

      mCloseGuard.open("release");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


public class Example3 {
  public static void main(String[] args) {
    WebPhoto photo = new WebPhoto("http://d.pr/i/1a8zn+");
  }
}
