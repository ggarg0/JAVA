package Core.exceptionhandling;

class NumberTest1 {
	public void accept(int n) throws ArithmeticException {
		if (n == 0) {
			throw new ArithmeticException("Can't assign zero...");
		}
	}

	public void handle(int n) {
		accept(n);
	}
}

public class ThrowsDemo11 {
	public static void main(String args[]) throws Exception {
		try {
			NumberTest1 ob = new NumberTest1();
			ob.handle(0);
			System.out.println("Gaurav");
		} catch (ArithmeticException e) {
			System.out.println("Exp : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Gaurav Exp");
		}
	}
}
