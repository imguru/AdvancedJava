class Point {
    private int x;
    private int y;

    public void print() {
        // ...
    }
}

public class Example6 {
    public static void doRegular() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Point a = new Point();
            a.print();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) throws Exception {
        doRegular();
    }
}