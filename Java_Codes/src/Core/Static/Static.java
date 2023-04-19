package Core.Static;

class Static {
	private int count;
	private final static int num = 10;

	public static void disp() {
		// System.out.println("Static count : " + count);
		System.out.println("Static num : " + num);
	}

	public void show() {
		System.out.println("show count : " + count);
		System.out.println("show num : " + num);
	}

	public static void main(String arg[]) {
		Static s1 = new Static();
		Static.disp();
		s1.show();
	}
}