import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface MyPredicate {
    boolean isOdd(int n);
    // boolean isEvent();

    // default method 는 허용한다.
    default boolean isEven(int n) {
        return !isOdd(n);
    }
}

public class Example9 {
    public static void foo(MyPredicate pred) {
        System.out.println(pred.isOdd(10));
    }

    public static void main(String[] args) {
        foo(new MyPredicate() {
            @Override
            public boolean isOdd(int n) {
                return n % 2 == 1;
            }
        });

        foo(n -> n % 2 == 1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
            }
        }).start();

        new Thread(() -> System.out.println("Thread start with Lambda")).start();

        List<String> s = Arrays.asList("Hello", "Lambda");
        s.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.indexOf(0) - o2.indexOf(0);
            }
        });

        s.sort((o1, o2) -> o1.indexOf(0) - o2.indexOf(0));
    }
}
