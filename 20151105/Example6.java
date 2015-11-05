package kr.co.ioacademy;

import java.math.BigDecimal;
import java.util.Arrays;



public class Example6 {
    public static void main(String[] args) {
        double value1 = 2.0 - 1.1;
        double value2 = 0.9;

        if (Math.abs(value1 - value2) < 0.001) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

        BigDecimal v = new BigDecimal(2.0).subtract(new BigDecimal(1.1));
        System.out.println(v);;

        BigDecimal v2 = new BigDecimal("2.0").subtract(new BigDecimal("1.1"));
        System.out.println(v2);;

        int[] arr1 = new int[20];
        int[] arr2 = new int[20];

        System.out.println(arr1.equals(arr2));

        System.out.println(Arrays.equals(arr1, arr2));
    }
}
