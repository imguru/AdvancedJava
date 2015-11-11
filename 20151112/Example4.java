package kr.co.ioacademy;

// try-finally ������ try ����� ��� �� finally ����� �ݵ�� �����մϴ�.
// try ����� ���������� ����ǵ� �� ���������� ����ǵ� ������ ����˴ϴ�.

// try ����� ����� ���õǰ� finally ����� ���ᰡ ���� ��ü�� ���� ������ �˴ϴ�.
// finally ���� �ȿ����� ���� return, break, continue ���� finally ����� ����� �ȵȴ�.
// ���ܰ� �߻��ϴ� �ϵ� ����� �Ѵ�.
public class Example13 {
  public static void main(String[] args) {
    System.out.println(result());
  }

  static boolean result() {
    try {
      return true;
    } finally {
      return false;
    }
  }
}

// �ڹٴ� 3���� ������ throwable�� �����Ѵ�.
// 1. ���� ���� ����(checked exception)

// 2. ������ ���� ����(unchecked exception)
//  1). ���� ���� ����(runtime exception)
//  2). ����(error)

// "API ����ڿ��� ���� ���� ���ܸ� �شٴ� ���� �� ���¸� ������ ������ �شٴ� ���̴�.
//  (������ �� ������ �����ϸ� �ȵȴ�.)
// "���� ���� ���ܿ� ������ ���� ����� �����ϴ�. �Ѵ� catch �� �ʿ䵵 ����,
//   ó���ؼ��� �ȵȴ�. 

// ���� ���� ���� vs ������ ���� ����
// 1. ���� ���� ���� : ������ ������ ��Ȳ
// 2. ������ ���� ���� : ������ �Ұ����� ��Ȳ
// 3. ����� ���� ���α׷��� ������ ���� ���� ����(runtime exception)�� ����ؾ� �Ѵ�.
// 4. ���� ����(error)�� JVM�� ������ ǥ���� �� ���ȴ�. 
//   (Error�� ���� Ŭ������ ������ �ʴ´�.)



