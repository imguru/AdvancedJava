package kr.co.ioacademy;

import java.lang.reflect.Field;

class Person {
    private String name;
    private String phone;

    public void setValue(String key, Object value) {
        switch (key) {
            case "name":
                this.name = (String) value;
                break;
            case "phone":
                this.phone = (String)value;
                break;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


public class Example4 {
    public static void main(String[] args) {
        Person person = new Person();

        String input = "name";
        String value = "Tom";

        person.setValue(input, value);
        System.out.println(person);
    }
}