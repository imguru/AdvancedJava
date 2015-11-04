package kr.co.ioacademy;

import java.lang.ref.WeakReference;

public class WeakSingleton {
	private static WeakReference<WeakSingleton> instance
	 = new WeakReference<WeakSingleton>(null);

	public static WeakSingleton getInstance()
	{
		WeakSingleton m = instance.get();
		if (m != null)
			return m;
		
		synchronized (WeakSingleton.class) {	
			
			System.out.println("Create new instance");
			
			m = new WeakSingleton();
			instance = new WeakReference<WeakSingleton>(m);		
		}
		
		return m;
	}
	
	public static void main(String[] args) {
		WeakSingleton w = WeakSingleton.getInstance();
		
		// System.gc();
		
		w = WeakSingleton.getInstance();
	}
}








