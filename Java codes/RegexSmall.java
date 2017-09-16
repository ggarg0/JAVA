import java.util.regex.*;

class RegexSmall
{
	public static void main(String [] a)
	{
		Pattern p=Pattern.compile("t");
		Matcher m=p.matcher("connection=tibco");

		while(m.find())
		{
			System.out.println(m.start()+" ");
		}

}
}