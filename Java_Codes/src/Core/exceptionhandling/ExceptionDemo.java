package Core.exceptionhandling;

public class ExceptionDemo {
	public static void main(String args[]) {
		try {
			int b = 1;
			int c = 5 / b;
			int[] arr = { 2, 6, 2 };
			String obj = new String();
			System.out.println("Code executed : " + obj.toLowerCase());
			System.out.println("Array : " + arr[5]);

		} catch (ArithmeticException ae) {
			System.out.println("Divided by zero " + ae);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		} finally {
			System.out.println("After Try and Catch blocks");
		}
		System.out.println("TESTs");
	}
}
