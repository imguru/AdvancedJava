package kr.co.ioacademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Example7 {
  public static void main(String[] args) {
    Map<Person, String> m = new HashMap<>();

    m.put(new Person("Tom", 42), "Google");

    System.out.println(m.get(new Person("Tom", 42))); 
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


