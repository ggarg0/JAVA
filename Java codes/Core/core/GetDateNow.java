package Core.core;

import java.util.*;
import java.text.SimpleDateFormat;

public class GetDateNow {
	public static void main(String arg[]) {

		Date d1 = new Date();
		System.out.println("Date Object without Formatter :=>  " + d1.toString());

		Calendar currentDate = Calendar.getInstance();
		System.out.println("Calendar Object without Formatter :=>  " + currentDate.getTime());

		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

		String dateNow = formatter.format(d1);
		System.out.println("Date Object with Formatter:=>  " + dateNow.toString());

		String dateNow1 = formatter.format(currentDate.getTime());
		System.out.println("Calendar Object with Formatter :=>  " + dateNow1);

		System.out.println("Test:=>  " + new SimpleDateFormat("MMddyyyyHHmmss").format(new Date()));
	}
}