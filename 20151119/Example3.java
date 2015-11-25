
import java.lang.reflect.Constructor;

// Reflection 을 통해서 객체를 생성하는 방법. - 동적 생성
// Spring - DI(Dependency Injection)
// iOS
public class Example3 {
  public static void main(String[] args) throws Exception {
    Class personClass = Person.class;

    // 1. 기본 생성자를 통한 객체 생성
    Person person = (Person) personClass.newInstance();
    System.out.println(person);

    // 2. 사용자 정의 생성자를 통한 객체 생성
    Class[] paramTypes = {
      String.class, int.class
    };

    // Constructor constructor = personClass.getConstructor(paramTypes);
    Constructor constructor = personClass.getDeclaredConstructor(paramTypes);
    System.out.println(constructor);

    Object[] cargs = {
        "Tom", 42
    };

    constructor.setAccessible(true);
    Person person2 = (Person) constructor.newInstance(cargs);
    System.out.println(person2);
  }
}

class Person {
  private String name;
  private int age;

  public Person() {
    this.name = "";
    this.age = 0;
  }

  private Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
