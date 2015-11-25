interface Calculator {
    int add(int a, int b);
    int sub(int a, int b);
    int div(int a, int b);
}

class CalculatorFactory {
    static class BasicCalculator implements Calculator {
        @Override
        public int add(int a, int b) { return a + b; }

        @Override
        public int sub(int a, int b) { return a - b; }

        @Override
        public int div(int a, int b) {
            if (b == 0)
                throw new IllegalArgumentException("Divisor cannot be zero");
            return a / b;
        }
    }

    public static Calculator defaultCalculator() {
        return new BasicCalculator();
    }
}

public class Example1 {
    public static void main(String[] args) {
        Calculator cal1 = CalculatorFactory.defaultCalculator();
        int sum = cal1.add(10, 20);

        System.out.println(sum);
    }
}





