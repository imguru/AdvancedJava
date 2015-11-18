

class Car {
    private Car instance = new Car();

    public Car() throws Exception {
        throw new Exception("Failed to create");
    }
}

public class Example9 {
    public static void main(String[] args) {
        try {
            Car p = new Car();
            System.out.println("Succeed");
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}