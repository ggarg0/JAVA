package Core.polymorphism;

class OverLoadingDemo {
	public int add(int num1, int num2) {
		System.out.print("Inside int");
		return num1 + num2;
	}

	private float add(float num1, float num2) {
		System.out.print("Inside float");
		return num1 + num2;
	}

	public static void main(String arg[]) {
		OverLoadingDemo overload = new OverLoadingDemo();
		System.out.println(" and intNumber=" + overload.add(11, 10));
		System.out.println(" and longNumber=" + overload.add(10.0f, 20));
		System.out.println(" and longNumber=" + overload.add(10, 20.0f));
		
		int d = 10;
		float f = 10.0f;
		f = d;
		System.out.println("f : " + f);
	}
}