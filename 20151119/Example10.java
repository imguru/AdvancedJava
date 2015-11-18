class Engine {
}

class Car {
    private static Class<Engine> engineClass = Engine.class;
    private Engine engine = engineClass.newInstance();
}

public class Example10 {
    public static void main(String[] args) {

    }
}