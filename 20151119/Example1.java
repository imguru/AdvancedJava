package kr.co.ioacademy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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

public class Example1 {
    public static void main(String[] args) throws Exception {

        Class personClass = new Person().getClass();
        // Class personClass = Person.class;
        // Class personClass = Class.forName("kr.co.ioacademy.Person");
        System.out.println("Class name : " + personClass.getName());

        int mods = personClass.getModifiers();
        System.out.println("public : " + Modifier.isPublic(mods));
        System.out.println("final : " + Modifier.isFinal(mods));
        System.out.println("abstract : " + Modifier.isAbstract(mods));

        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.print(m.getName());
            System.out.println(m.getParameterCount());
            Class[] params = m.getParameterTypes();
            for (Class p : params) {
                System.out.println("\t" + p.getName());
            }
        }
    }
}