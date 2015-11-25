import java.util.function.Function;

// % javap -p -c -v  Example10.class
// % javap -p -c -v Example10$1.class

public class Example10 {
    public static void main(String[] args) {
        Function<Object, String> f = new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return o.toString();
            }
        };

        Function<Object, String> f2 = obj -> obj.toString();

        // Function<Object, String> f3 = Object::toString;
    }
}
