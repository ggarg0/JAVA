import java.util.regex.*;

class RegexSmall
{
	private static final String EMAIL_PATTERN =
			"^[_F-Zf-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static void main(String [] a)
	{
		Pattern p=Pattern.compile(EMAIL_PATTERN);
		Matcher m=p.matcher("fah@gmail.com");
		System.out.println(m.matches());
}
}