class OverLoadingDemo {
		public int add(int num1,int num2)
		{
					System.out.println("Inside int");
					return num1+num2;
		}
		public float add(float num1,int num2)
		{
				System.out.println("Inside long");
				return num1+num2;
		}
		public static void main(String arg[])
		{
			OverLoadingDemo overload=new OverLoadingDemo();
			int intNumber=overload.add(11,10);
			float longNumber=overload.add(10.0,20);

			System.out.println("intNumber="+intNumber);
			System.out.println("longNumber="+longNumber);

		}
}