package kr.co.ioacademy;

import java.math.BigDecimal;
import java.util.Arrays;

// 1. float�̳� double�� ==���� ���ϸ� �ȵȴ�.
// 2. ������ ������ �ʿ�� �Ѵٸ� BigDecimal �� ����ؾ� �Ѵ�.
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

    // ���� ���� : BigDecimal(String)�� �����ڸ� ����ؾ� �Ѵ�.
    BigDecimal v2 = new BigDecimal("2.0").subtract(new BigDecimal("1.1"));
    System.out.println(v2);;

    //-------------------------------------------------
    // 3. �迭 ������ ���Ϸ��� Object.equals() �� �ƴ� Arrays.equals()
    //    ����ؾ� �Ѵ�.
    int[] arr1 = new int[20];
    int[] arr2 = new int[20];

    System.out.println(arr1.equals(arr2));

    System.out.println(Arrays.equals(arr1, arr2));
  }
}
