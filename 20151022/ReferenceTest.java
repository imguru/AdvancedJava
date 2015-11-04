package kr.co.ioacademy;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

// 강한 참조(Strong Reference)
// 일반적으로 new를 통해서 객체를 생성하게 되면 생기게 되는 참조.

// 강한 참조를 통해 참조되고 있는 객체는 절대 가비지 컬렉션의 대상에서
// 제외된다.
// 자바에서 아무리 자동적으로 메모리가 수거된다고 하지만, 
// 참조에 대해서 해지하지 않는 다면 그 메모리는 절대 수거되지 않는다.
//  (참조 = null , 참조 = 다른객체)

// OutOfMemory를 방지하기 위해서는 약한 형태의 참조를 사용해야 한다.
//  SoftReference<>, WeakReference<>

// http://d.pr/n/cuGy
// Soft Reference
// 생성 방법 : SoftReference<Data> r
            // = new SoftReference<Data>(new Data);
// 동작 : 강한 참조와 다르게 GC에 의해 수거될 수도 있고, 수거되지 않을 수도 있다.
//  메모리에 충분한 여유가 있다면 GC가 수행되고 있다고 하더라도 수거되지 않는다.
//  하지만 out of memory의 시점이 가깝다면, 수거될 확률이 높다.

// Weak Reference
//생성 방법 : WeakReference<Data> r
// = new WeakReference<Data>(new Data);

// WeakReference에 의해 참조된 객체는 가비지 컬렉션이 발생하기 전까지는 참조를 유지
// 하지만 GC가 발생하는 순간 무조건 수거된다.
// WeakReference가 사라지는 시점이 GC의 실행 주기와 일치한다.
// 이를 이용하면 짧은 주기에 자주 사용되는 객체를 캐시할 때 유용하다.
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




