package Core.exceptionhandling;

public class ExceptionDemo {
	public static void main(String argx[]) {
		try {
			int a[] = { 1, 2 };
			int b = 0;
			int c = 5 / b;
			System.out.println("TESTing");
		} catch (ArithmeticException ae) {
			System.out.println("Divided by zero" + ae);
		} catch (Exception e) {
			System.out.println("Error");
		} finally {
			System.out.println("After Try and Catch blocks");
		}
		System.out.println("TESTs");
	}
}
