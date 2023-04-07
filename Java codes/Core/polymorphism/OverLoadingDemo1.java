package Core.polymorphism;

class OverLoadingDemo1 {
	private OverLoadingDemo1(Object o) {
		System.out.println("Inside Object");
	}

	private OverLoadingDemo1(String o) {
		System.out.println("Inside String");
	}

	private OverLoadingDemo1(int s) {
		System.out.println("Inside int");
	}

	public static void main(String arg[]) {
		new OverLoadingDemo1(12);
		new OverLoadingDemo1(new Object());
		new OverLoadingDemo1(new String("s1"));
		new OverLoadingDemo1(new StringBuffer("Asa"));
		new OverLoadingDemo1("");
		new OverLoadingDemo1(null);
	}
}