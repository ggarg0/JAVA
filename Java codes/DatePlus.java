import java.text.*;
import java.util.*;

public class DatePlus
{
	public static void main(String[] args)
    {
        Date date = new Date(117, 10, 1);
        DateFormat currentDate = DateFormat.getDateInstance();
        System.out.println(currentDate.format(date));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 70); // add 10 days
		date = cal.getTime();
        System.out.println(currentDate.format(date));

        Date currDate = new Date(118, 3, 8);
        System.out.println(currDate);
    	System.out.println((new Date().getTime() - currDate.getTime())/(1000 * 60 * 60 * 24));
    }
}