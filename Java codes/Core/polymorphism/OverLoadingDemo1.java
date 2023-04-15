package Core.polymorphism;

class OverLoadingDemo1 {
	OverLoadingDemo1(Object o) {
		System.out.println("Inside Object");
	}

	OverLoadingDemo1(String o) {
		System.out.println("Inside String");
	}

	OverLoadingDemo1(int s) {
		System.out.println("Inside int");
	}

	public static void main(String arg[]) {
		//OverLoadingDemo1 obj;
		new OverLoadingDemo1(12);
		new OverLoadingDemo1(new Object());
		new OverLoadingDemo1(new String("s1"));
		new OverLoadingDemo1(new StringBuffer("Asa"));
		new OverLoadingDemo1("");
		new OverLoadingDemo1(null);
	}
}