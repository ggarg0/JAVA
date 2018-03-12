import java.util.regex.Pattern;

class validPattern{
public static final Pattern validIAPattern = Pattern.compile("abc|efg");

public void emailCheck(String a){
	if (validIAPattern.matcher(a).matches()) {
				System.out.println("Fine : " + a);
			}
		else{
		System.out.println("not Fine : " + a);
	}
}

public static void main(String[] a)
{
	try{


		validPattern obj = new validPattern();
		obj.emailCheck("abc");
	}catch(Exception e)
	{
		System.out.println("Divide by Zero ..... ");
	}
}
}