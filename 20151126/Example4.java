interface A {
    default void hello() {
        System.out.println("inside A");
    }
}

interface B {}
interface C extends A {
    default void hello() {
        System.out.println("inside C");
    }
}

public class Example4 implements C, B, A {
    public static void main(String[] args) {
        new Example4().hello();
    }
}