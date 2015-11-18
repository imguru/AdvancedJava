import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    boolean enabled() default true;
}

public class Example7 {
    @Test
    public void testA() {
        System.out.println("do Something");
    }

    @Test
    public void testB() {
        System.out.println("do Something");
        throw new RuntimeException("failed");
    }

    @Test
    public void testC() {
        System.out.println("do Something");
    }

    public static void main(String[] args) throws Exception {
    }
}