package kr.co.ioacademy;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

class WebPhoto {
  Image image;
  
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
  public static void main(String[] args) {
   
    WebPhoto photo = new WebPhoto("http://d.pr/i/1a8zn+");    
  }
}
