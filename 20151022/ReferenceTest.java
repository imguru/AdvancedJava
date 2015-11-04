package kr.co.ioacademy;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

// ���� ����(Strong Reference)
// �Ϲ������� new�� ���ؼ� ��ü�� �����ϰ� �Ǹ� ����� �Ǵ� ����.

// ���� ������ ���� �����ǰ� �ִ� ��ü�� ���� ������ �÷����� ��󿡼�
// ���ܵȴ�.
// �ڹٿ��� �ƹ��� �ڵ������� �޸𸮰� ���ŵȴٰ� ������, 
// ������ ���ؼ� �������� �ʴ� �ٸ� �� �޸𸮴� ���� ���ŵ��� �ʴ´�.
//  (���� = null , ���� = �ٸ���ü)

// OutOfMemory�� �����ϱ� ���ؼ��� ���� ������ ������ ����ؾ� �Ѵ�.
//  SoftReference<>, WeakReference<>

// http://d.pr/n/cuGy
// Soft Reference
// ���� ��� : SoftReference<Data> r
            // = new SoftReference<Data>(new Data);
// ���� : ���� ������ �ٸ��� GC�� ���� ���ŵ� ���� �ְ�, ���ŵ��� ���� ���� �ִ�.
//  �޸𸮿� ����� ������ �ִٸ� GC�� ����ǰ� �ִٰ� �ϴ��� ���ŵ��� �ʴ´�.
//  ������ out of memory�� ������ �����ٸ�, ���ŵ� Ȯ���� ����.

// Weak Reference
//���� ��� : WeakReference<Data> r
// = new WeakReference<Data>(new Data);

// WeakReference�� ���� ������ ��ü�� ������ �÷����� �߻��ϱ� �������� ������ ����
// ������ GC�� �߻��ϴ� ���� ������ ���ŵȴ�.
// WeakReference�� ������� ������ GC�� ���� �ֱ�� ��ġ�Ѵ�.
// �̸� �̿��ϸ� ª�� �ֱ⿡ ���� ���Ǵ� ��ü�� ĳ���� �� �����ϴ�.
// => WeakHashMap
// WeakHashMap<K,V>

// PhantomReference

class BigData {
	private int[] array = new int[5000]; // 20000byte, 20K
}

public class ReferenceTest {

	private List<WeakReference<BigData>> refs = new LinkedList<>();

	public void referenceTest() {
		try {
			for (int i = 0; true; i++) {
				refs.add(new WeakReference<BigData>(new BigData()));
			}
		} catch (OutOfMemoryError ofm) {
			System.out.println("out of memory!");
		}
	}

	public static void main(String[] args) {
		System.out.println("run");
		// Thread.sleep(10 * 1000);
		ReferenceTest test = new ReferenceTest();
		test.referenceTest();
		System.out.println("finish");
	}
	
}




