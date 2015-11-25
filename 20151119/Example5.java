
// Reflection 활용 2.

class Shape {
}

class Rect extends Shape {
}

class Circle extends Shape {
}

class Triangle extends Shape {
}

// Reflection 활용 2.
// 팩토리
// 개념 : 객체를 생성하는 객체
// 장점 : 객체 생성에 관한 코드를 한곳에 모아서 중앙집중적으로 관리하는 것이 가능하다.
// 단점 : 도형의 종류가 늘어남에 따라 팩토리의 코드는 수정되어야만 한다.
//        OCP 를 만족할 수 없다.

class ShapeFactory {
  public Shape createShape(String name) {
    Class clazz = null;
    try {
      clazz = Class.forName(name);
      return (Shape) clazz.newInstance();
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }

    return null;
  }


//  public Shape createShape(String name) {
//    if (name.equals("Rect"))
//      return new Rect();
//    else if (name.equals("Circle"))
//      return new Circle();
//    else if (name.equals("Triangle"))
//      return new Triangle();
//
//    return null;
//  }
}


public class Example5 {
}
