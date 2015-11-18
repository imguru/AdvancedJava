class Shape {
}

class Rect extends Shape {
}

class Circle extends Shape {
}


class ShapeFactory {
    public Shape createShape(String name) {
        if (name.equals("Rect"))
            return new Rect();
        else if (name.equals("Circle"))
            return new Circle();

        return null;
    }
}

public class Example5 {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s = factory.createShape("Rect");

        System.out.println(s);
    }
}