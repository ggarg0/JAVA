package Core.Final;

class FinalVariable {
	private final int count;
	private static final double pi = 3.14;

	FinalVariable(int count) {
		this.count = count;
		// pi=3.1464564;

	}

	void disp() {
		// pi=3.2;
		// count = 14;
		final int x;
		x = 12;
		System.out.println("Inside disp pi : " + pi);
		System.out.println("Inside disp count : " + count);
		//x=10;
		System.out.println("Inside disp x : " + x);

	}

	public static void main(String args[]) {
		FinalVariable f1 = new FinalVariable(10);
		f1.disp();
	}
}
