package Core.exceptionhandling;

class TryFinally {
	public int divide(int a) {
		int b = 0;
		b = 10 / a;
		return b;
	}

	public static void main(String[] a) {
		try {
			TryFinally obj = new TryFinally();
			int result = obj.divide(0);
			System.out.println("result Main : " + result);
		} catch (Exception e) {
			System.out.println("Divide by Zero 1..... ");
		}
	}
}