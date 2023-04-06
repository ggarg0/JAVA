package Core.core;

import java.util.Calendar;
import java.util.GregorianCalendar;

class CalendarDemo {
	public static void main(String arg[]) {
		Calendar calendar = new GregorianCalendar();
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));

		Calendar newyear = new GregorianCalendar((calendar.get(Calendar.YEAR) + 1), 0, 1);
		System.out.println("YEAR: " + newyear.get(Calendar.YEAR));
		System.out.println("MONTH: " + newyear.get(Calendar.MONTH));
		System.out.println("DATE: " + newyear.get(Calendar.DATE));
	}
}
