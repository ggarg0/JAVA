package Core.core;

class Operator {
	public static void main(String arg[]) {
		int number1 = 100;
		int number2 = 100;

		if ((number1 <= 50) && (++number1 >= 101)) {
			System.out.println("TRUE");
		}

		if ((number2 >= 50) && (++number2 >= 101)) {
			System.out.println("TRUE");
		}
		System.out.println(number1);
		System.out.println(number2);

	}
}