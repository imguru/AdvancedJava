interface A {
    default void hello() {
        System.out.println("inside A");
    }
}

class Example3 implements A {
    @Override
    public void hello() {
        System.out.println("inside App");
    }

    public static void main(String[] args) {
        new Example3().hello();
    }
}
