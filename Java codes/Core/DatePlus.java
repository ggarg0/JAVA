package Core;
import java.util.Date;

public class DatePlus
{
	public static void main(String[] args)
    {
        Date currDate = new Date(120, 0, 1);
        System.out.println(currDate);

        Date currDate1 = new Date(120, 7, 9);
        System.out.println(currDate1);
    	System.out.println((currDate1.getTime() - currDate.getTime())/(1000 * 60 * 60 * 24));

    	Date nowDate = new Date();
    	//System.out.println((nowDate) - (date));
    }
}