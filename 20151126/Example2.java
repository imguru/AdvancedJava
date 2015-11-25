interface Calculator {
    int add(int a, int b);
    int sub(int a, int b);
    int div(int a, int b);

    default int mul(int a, int b) {
        int n = 0;
        for (int i = 0 ; i < b ; i++)
            n = add(n, a);
        return n;
    }

    class BasicCalculator implements Calculator {
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

    static Calculator defaultCalculator() {
        return new BasicCalculator();
    }
}

public class Example2 {
    public static void main(String[] args) {
        Calculator cal1 = Calculator.defaultCalculator();
        int sum = cal1.mul(10, 21);

        System.out.println(sum);
    }
}





