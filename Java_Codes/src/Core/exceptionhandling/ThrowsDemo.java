package Core.exceptionhandling;

class NumberTest {
	private int num;

	public int divide(int n) {
		int a = 0;
		try {
			a = 10 / n;
			return a;
		} catch (ArithmeticException e) {
			System.out.println("from ArithmeticException : " + e.getMessage());
			throw e;
		} finally {
			System.out.println("from finally : " + num);
			// return 100;
		}
	}
}

public class ThrowsDemo {
	public static void main(String args[]) {
		try {
			NumberTest ob = new NumberTest();
			int ret = ob.divide(0);
			System.out.println("ret : " + ret);
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
}
