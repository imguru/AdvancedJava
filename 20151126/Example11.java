import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

abstract class Shape {}

class Rect extends Shape {
}

class Circle extends Shape {
}

class Triangle extends Shape {
}

class ShapeFactory {
    private static Map<String, Supplier<Shape>> map = new HashMap<>();

    public static void registerShape(String name, Supplier<Shape> supplier) {
        map.put(name, supplier);
    }

    public static Shape createShape(String name) {
        Supplier<Shape> p = map.get(name);
        if (p != null)
            return p.get();

        throw new IllegalArgumentException("No such shape " + name);
    }
}

class Example11 {
    public static void main(String[] args) {
        ShapeFactory.registerShape(Rect.class.getName(), Rect::new);
        ShapeFactory.registerShape(Rect.class.getName(), Circle::new);
        ShapeFactory.registerShape(Rect.class.getName(), Triangle::new);

        Rect rect = (Rect) ShapeFactory.createShape("Rect");
    }
}