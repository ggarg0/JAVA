class Access{
	private int a;
	protected int b;
	int c;
	public int d;
}

class AccessDemo{
	public static void main(String arg[])
	{
			Access access=new Access();
			System.out.println(access.a);
			System.out.println(access.b);
			System.out.println(access.c);
			System.out.println(access.d);

	}
}

/* Note: Identify the error, rectify it and get the output. */