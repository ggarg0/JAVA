package Core;

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
		System.out.println(new OverLoadingDemo1(12));
		System.out.println(new OverLoadingDemo1(new Object()));
		System.out.println(new OverLoadingDemo1(new String("s1")));
		System.out.println(new OverLoadingDemo1(new StringBuffer("Asa")));
		System.out.println(new OverLoadingDemo1(""));
		System.out.println(new OverLoadingDemo1(null));
	}
}