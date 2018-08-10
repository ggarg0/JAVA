class MyOuter
{
	private int x=12;
	public void makeInner()
	{
		MyInner in=new MyInner();
		in.seeOuter();
	}
	class MyInner
	{
		public void seeOuter()
		{
			System.out.println("Outer x : "+ x);
		}
	}
	public static void main(String[] a)
	{
		MyOuter out=new MyOuter();
		MyOuter.MyInner in1= new MyOuter().new MyInner();

		out.makeInner();
		in1.seeOuter();

	}
}