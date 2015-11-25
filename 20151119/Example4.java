import java.lang.reflect.Field;

// Reflection 활용 1.
// Key-Value Coding : setter / getter
// Objective-C 기본으로 제공하고 있는 기능.
public class Example4 {
  public static void main(String[] args) {
    Person person = new Person();

    String input = "name";
    String value = "Tom";

    person.setValue(input, value);
    person.setValue("phone", "010-1111-2222");
    person.setValue("age", 200);

    System.out.println(person.getValue("name"));
    System.out.println(person.getValue("age"));


    if (input.equals("name"))
      person.setName(value);
    else if (input.equals("phone"))
      person.setPhone(value);

  }
}

class Person {
  private String name;
  private String phone;
  private int age;

  public Object getValue(String key) {
    Class clazz = this.getClass();
    Field field;

    try {
      field = clazz.getDeclaredField(key);
      return field.get(this);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

  public void setValue(String key, Object value) {
    Class clazz = this.getClass(); // Person.class
    try {
      Field filed = clazz.getDeclaredField(key);
      filed.set(this, value);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public void setValue(String key, Object value) {
    switch (key) {
      case "name":
        this.name = (String) value;
        break;
      case "phone":
        this.phone = (String) phone;
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











