package kr.co.ioacademy;

import java.lang.reflect.Field;

class Point {
    public int x;
    public int y;

    private int z;
    public int z() {
        return z;
    }
}

public class Example2 {
    public static void main(String[] args) throws Exception {
        Point point = new Point();

        Field xField = point.getClass().getField("x");
        Field yField = point.getClass().getField("y");

        System.out.println(xField.get(point) + ", " + yField.get(point));

        xField.setInt(point, 10);
        yField.setInt(point, 20);

        System.out.println(xField.get(point) + ", " + yField.get(point));
    }
}