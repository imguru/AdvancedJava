package kr.co.ioacademy;

import java.lang.reflect.Constructor;

class Person {
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

public class Example3 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        Person person = (Person) personClass.newInstance();

        System.out.println(person);

        Class[] paramTypes = {
                String.class, int.class
        };

        Constructor constructor = personClass.getConstructor(paramTypes);
        System.out.println(constructor);

        Object[] cargs = {
                "Tom", 42
        };

        Person person2 = (Person) constructor.newInstance(cargs);
        System.out.println(person2);
    }
}