class OverLoadingDemo1 {
		public OverLoadingDemo1(Object o)
		{
					System.out.println("Inside Object");

		}
		private OverLoadingDemo1(String s)
		{
				System.out.println("Inside String");

		}
		public static void main(String arg[])
		{
			String s1 = null;
			OverLoadingDemo1 overload=new OverLoadingDemo1(null);


		}
}