package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

class WebPhoto {
  Image image;

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
    
  }
}
