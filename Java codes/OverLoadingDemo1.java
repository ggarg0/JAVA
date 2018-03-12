class OverLoadingDemo1 {
		private OverLoadingDemo1(Object o)
		{
					System.out.println("Inside Object");

		}
		private OverLoadingDemo1(String s)
		{
				System.out.println("Inside String");

		}
		public static void main(String arg[])
		{
			String s1 = new String();
			OverLoadingDemo1 overload=new OverLoadingDemo1(s1);
			OverLoadingDemo1 overload2=new OverLoadingDemo1(null);
			OverLoadingDemo1 overload1=new OverLoadingDemo1(new Object());
			OverLoadingDemo1 overload4=new OverLoadingDemo1(new String("Asa"));

		}
}