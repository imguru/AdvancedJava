package kr.co.ioacademy;

import java.math.BigDecimal;
import java.util.Arrays;

// 1. float이나 double은 ==으로 비교하면 안된다.
// 2. 정밀한 연산을 필요로 한다면 BigDecimal 을 사용해야 한다.
public class Example6 {
  public static void main(String[] args) {

    double value1 = 2.0 - 1.1;
    double value2 = 0.9;

    // if (value1 == value2) {
    if (Math.abs(value1 - value2) < 0.001) {
      System.out.println("same");
    } else {
      System.out.println("not same");
    }

    BigDecimal v = new BigDecimal(2.0).subtract(new BigDecimal(1.1));
    System.out.println(v);;

    // 주의 사항 : BigDecimal(String)의 생성자를 사용해야 한다.
    BigDecimal v2 = new BigDecimal("2.0").subtract(new BigDecimal("1.1"));
    System.out.println(v2);;

    //-------------------------------------------------
    // 3. 배열 내용을 비교하려면 Object.equals() 가 아닌 Arrays.equals()
    //    사용해야 한다.
    int[] arr1 = new int[20];
    int[] arr2 = new int[20];

    System.out.println(arr1.equals(arr2));

    System.out.println(Arrays.equals(arr1, arr2));
  }
}
