package Core.polymorphism;

class OverLoadingDemo {
	public int add(int num1, int num2) {
		System.out.println("Inside int");
		return num1 + num2;
	}

	private float add(float num1, float num2) {
		System.out.println("Inside float");
		return num1 + num2;
	}

	public static void main(String arg[]) {
		OverLoadingDemo overload = new OverLoadingDemo();
		int intNumber = overload.add(11, 10);
		float longNumber = overload.add(10.0f, 20);
		float longNumber1 = overload.add(10, 20.0f);

		System.out.println("intNumber=" + intNumber);
		System.out.println("longNumber=" + longNumber);
		System.out.println("longNumber=" + longNumber1);

	}
}