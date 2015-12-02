import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class Example2 {
    public static void main(String[] args) {
        List<Point> points = Point.points();

        List<Point> results = new ArrayList<>();
        for (Point p : points) {
            if (p.getX() >= 10)
                results.add(p);
        }

        List<Point> results2 = results.stream()
                .filter(point -> point.getX() >= 10)
                .collect(Collectors.toList());

        List<Point> results3 = results.parallelStream()
                .filter(point -> point.getX() >= 10)
                .collect(Collectors.toList());
    }
}


class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    static List<Point> points() {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++)
            points.add(new Point(random.nextInt(100), random.nextInt(100)));
        return points;
    }
}