package Core;
class Access1 {
	protected int a;
	public int d;
}

class AccessSpec {
	public static void main(String arg[]) {
		Access1 access = new Access1();
		System.out.println(access.a);
		System.out.println(access.d);

	}
}