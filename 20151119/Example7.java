// Simple JUnit4
// 어노테이션(Annotation) ; 주석
// Comment : 비공식적이고 임시적이다.
// 정의 : 자바의 각 요소(클래스, 메소드, 필드, 매개변수) 가 가질 수 있는
//        주석 리소스

// 목적
// 1. 컴파일러에게 추가적인 정보 전달
// 2. 컴파일 할 때와 설치시의 작업 지정
// 3. 실행할 때 별도의 처리를 수행

// 기본 어노테이션
// 1. @Override
// 2. @Deprecated
// 3. @SuppressWarnings

// 1. 어노테이션을 만드는 방법.

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
    System.out.println("testA : do something");
  }

  @Test(enabled = true)
  public void testB() {
    System.out.println("testB : do something");
    throw new RuntimeException("failed to run");
  }

  @Test(enabled = true)
  public void testC() {
    System.out.println("testC : do something");
  }

  public static void main(String[] args) {
    System.out.println("Testing....");

    int count = 0;
    int passed = 0;
    int failed = 0;
    int ignore = 0;

    Class obj = Example7.class;
    for (Method method : obj.getDeclaredMethods()) {

      if (method.isAnnotationPresent(Test.class)) {
        ++count;
        Annotation annotation = method.getAnnotation(Test.class);
        Test test = (Test) annotation;

        if (test.enabled()) {
          try {
            method.invoke(obj.newInstance());
            ++passed;
            System.out.printf("Test '%s' - passed\n", method.getName());
          } catch (Throwable e) {
            ++failed;
            System.out.printf("Test '%s' - failed : %s\n", method.getName(),
                e.getCause());
          }
        } else {
          ++ignore;
          System.out.printf("Test '%s' ignored\n", method.getName());
        }
      }
    } // for

    System.out.printf("Result - Total:%d, Passed:%d, Failed:%d, Ignore:%d\n",
        count, passed, failed, ignore);
  }

}












