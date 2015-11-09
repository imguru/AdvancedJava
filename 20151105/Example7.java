package kr.co.ioacademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;


// 핵심 : 같은 객체는 동일한 해시 코드 값을 가져야 한다.
// 즉 equals를 재정의한 클래스는 반드시 hashCode도 재정의해야 한다.
// 그래야 HashMap, HashSet, HashTable 등 hash 기반 컬렉션과 함께 사용하면 오동작 하게 된다.

public class Example7 {
  public static void main(String[] args) {
    Map<Person, String> m = new HashMap<>();

    m.put(new Person("Tom", 42), "Google");

    System.out.println(m.get(new Person("Tom", 42)));

    // toString()을 잘 만들어 놓으면 편리하다.
    System.out.println(new Person("IU", 42));
  }
}


class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).add("age", age).toString();
  }

  @Override
  public int hashCode() {
    // equals 에 이용된 중요 필드를 이용해서 hash를 생성하면 된다.
    return Objects.hash(name, age);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o instanceof Person) {
      Person p = (Person) o;
      return Objects.equals(name, p.name) && age == p.age;
    }

    return false;
  }
}


