package Core;

class FinalVariable {
	private int count;
	private final double pi = 2;

	FinalVariable(int count) {
		this.count = count;
		// pi=3.14;
	}

	void disp() {
		// pi=3.2;
		final int x = 12;

		System.out.println("Inside disp pi " + pi);
		System.out.println("Inside disp x " + x);

	}

	public static void main(String args[]) {
		FinalVariable f1 = new FinalVariable(10);
		f1.disp();
	}
}

/* Note: Identify the error, rectify the same and get the output. */