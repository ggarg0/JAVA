public class pattern
{
	public static void main(String a[])
	{
		for(int i=4;i>=0;i--)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print(" ");
			}
			for(int k=0;i<j;k++)
		   {
							System.out.print("*");
			}
			System.out.println("");
		}

	}
}