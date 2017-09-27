class AutoBoxing{
	public static void main(String arg[]){

		/* Wrapper class usage without the help of AutoBoxing before jdk.1.5 */

		Integer num=new Integer(10);
		System.out.println("num value is"+num.intValue());

		/* Autoboxing and Unboxing from jdk.15 */

		Integer num1= new Integer(10);
		Integer num2= new Integer(20);

		System.out.println("sum is "+(num1.intValue()+num2.intValue()));

	}
}

/* Note: Analyze the code and understand the output. */