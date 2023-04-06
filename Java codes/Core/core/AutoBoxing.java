package Core.core;

class AutoBoxing {
	public static void main(String arg[]) {
		Integer num = new Integer(10);
		System.out.println("num value is" + num.intValue());

		Integer num1 = new Integer(10);
		Integer num2 = new Integer(20);

		System.out.println("sum is " + (num1.intValue() + num2.intValue()));
	}
}
