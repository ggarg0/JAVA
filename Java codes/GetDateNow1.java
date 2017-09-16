import java.util.*;
import java.text.SimpleDateFormat;

public class GetDateNow1 {
  public static void  main(String arg[]) {

  Date d1=new Date();
  SimpleDateFormat formatter=
  new SimpleDateFormat("dd/MMM/yyyy");

  String dateNow = formatter.format(d1);
  System.out.println("Date Object with Formatter:=>  " + dateNow);



  }
}