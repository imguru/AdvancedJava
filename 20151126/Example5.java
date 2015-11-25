interface A {
    default void hello() {
        System.out.println("inside A");
    }
}

interface B {
    default void hello() {
        System.out.println("inside B");
    }
}

public class Example5 implements B, A {
    @Override
    public void hello() {
        // B.super.hello();
        A.super.hello();
    }

    public static void main(String[] args) {
        new Example5().hello();
    }
}