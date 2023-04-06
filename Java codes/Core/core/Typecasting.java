package Core.core;

class Typecasting {
	public static void main(String arg[]) {

		long longNumber = 200;
		float floatNumber = 123.5F;
		double doubleNumber = 12.5;
		int intNumber = 100;

		doubleNumber = floatNumber;
		longNumber = intNumber;

		System.out.println(doubleNumber);
		System.out.println(longNumber);
	}
}