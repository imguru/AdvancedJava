package kr.co.ioacademy;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

class Person {
	private final Date birthDate;

	public Person(Date b) {
		this.birthDate = b;
	}

	// 아래 메소드가 호출될 때마다 생성되는 객체는 다음과 같다.
	// 1. Calendar
	// 2. TimeZone
	// 3. Date 2개
	public boolean isTeenager() {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1996, Calendar.JANUARY, 1, 0, 0, 0);
		Date start = gmtCal.getTime();

		gmtCal.set(2005, Calendar.JANUARY, 1, 0, 0, 0);
		Date end = gmtCal.getTime();

		return birthDate.compareTo(start) >= 0 && birthDate.compareTo(end) < 0;
	}

	private static final Date START;
	private static final Date END;

	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1996, Calendar.JANUARY, 1, 0, 0, 0);
		START = gmtCal.getTime();

		gmtCal.set(2005, Calendar.JANUARY, 1, 0, 0, 0);
		END = gmtCal.getTime();
	}

	public boolean isTeenager2() {
		return birthDate.compareTo(START) >= 0 && birthDate.compareTo(END) < 0;
	}
}

public class Example9 {
	@Test
	public void test_isTeen() {
		Calendar c = Calendar.getInstance();
		c.set(1995, Calendar.MAY, 5);

		Person p = new Person(c.getTime());

		for (int i = 0; i < 100000000; ++i) {
			p.isTeenager();
		}
	}

	@Test
	public void test_isTeen2() {
		Calendar c = Calendar.getInstance();
		c.set(1995, Calendar.MAY, 5);

		Person p = new Person(c.getTime());

		for (int i = 0; i < 100000000; ++i) {
			p.isTeenager2();
		}
	}
	
	
	

}
