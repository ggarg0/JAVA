package Core.polymorphism;

class OverLoadingDemo {
	private int add(int num1, int num2) throws Exception {
		System.out.print("Inside int");
		return num1 + num2;
	}

	float add(float num1, float num2) {
		System.out.print("Inside float");
		return num1 + num2;
	}

	public static void main(String arg[]) {
		try {
			OverLoadingDemo overload = new OverLoadingDemo();
			System.out.println(" and intNumber=" + overload.add(11, 10));
			System.out.println(" and longNumber=" + overload.add(10.0f, 20.0f));
			System.out.println(" and longNumber=" + overload.add(10, 20.0f));

			int d = 10;
			long f = 15;
			f = d;
			System.out.println("f : " + f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}