package Core.Static;

class StaticDemo {
	static int number;
	private int count;

	StaticDemo(int number, int count) {
		System.out.println("Inside Constructor");
		this.number = number;
		this.count = count;
	}

	public void disp() {
		int x = 12;
		System.out.println("number=" + number);
		System.out.println("count=" + count);
		System.out.println("x=" + x);
	}

	public static void StaticDisp() {
		int x = 122;
		System.out.println("x=" + x);
	}

	static {
		System.out.println("Inside Static");
		number = 99;
	}

	{
		System.out.println("Inside Block");
	}

	public static void main(String arg[]) {
		System.out.println("number=" + number);
		StaticDemo s1 = new StaticDemo(10, 20);
		s1.disp();
		StaticDisp();
		/*
		 * StaticDemo s2=new StaticDemo(100,200); s2.disp();
		 */
		System.out.println("number=" + number);

	}
}