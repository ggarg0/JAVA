public class resverseString
{
	public static void main(String a1[])
	{
		String a="Gaurav";
		System.out.println(a.length());
		String r="";
		for(int i=a.length()-1;i>=0;i--)
		{
			r+=a.charAt(i);

		}
		System.out.println(r);

	/*	StringBuffer o = new StringBuffer("gaurav");
		o.reverse();
		 System.out.println(o);
*/
	}
}