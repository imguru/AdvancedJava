
// Reflection(Instropection)
// 개념 : Class 이름만으로도 클래스의 정보(필드, 메소드)를 찾거나
//       객체를 생성할 수 있는 기능.

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Example1 {
  public static void main(String[] args) throws Exception {
    // 1. Class 얻기
    // a. 객체를 통해서 얻는 방법.
    // Class personClass = new Person().getClass();

    // b. Class type으로 얻어내는 방법.
    // Class personClass = Person.class;

    // c. 문자열로 얻어내는 방법.
    Class personClass = Class.forName("Person");

    // 2. Class 이름
    System.out.println(personClass.getName());       // kr.co.Person
    System.out.println(personClass.getSimpleName()); // Person
    System.out.println(personClass.getCanonicalName());

    int mods = personClass.getModifiers();

    // 3. Class 속성
    System.out.println("public : " + Modifier.isPublic(mods));
    System.out.println("final : " + Modifier.isFinal(mods));
    System.out.println("abstract : " + Modifier.isAbstract(mods));

    // 4. Method 속성
    Method[] methods = personClass.getMethods();
    for (Method m : methods) {
      System.out.println(m.getName());
      System.out.println(m.getParameterCount());
      Class[] params = m.getParameterTypes();
      for (Class p : params) {
        System.out.println("\t" + p.getName());
      }
    }
  }
}

final class Person {
  private String name;
  private int age;

  public Person() {
    this.name = "";
    this.age = 0;
  }

  public Person(String name, int age) {
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
