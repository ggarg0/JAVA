package Core.core;

class AutoBoxing {
	public static void main(String arg[]) {
		Integer num = Integer.valueOf(10);
		System.out.println("num value is" + num.intValue());

		Integer num1 = Integer.valueOf(10);
		Integer num2 = Integer.valueOf(20);

		System.out.println("sum is " + (num1.intValue() + num2.intValue()));
	}
}
