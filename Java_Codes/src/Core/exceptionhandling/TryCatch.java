package Core.exceptionhandling;

class TryCatch {
	public int divide(int a) {
		int b = 0;
		b = 10 / a;
		return b;
	}

	public static void main(String[] a) {
		try {
			TryCatch obj = new TryCatch();
			int[] arr = { 5, 8, 6 };
			int result = obj.divide(3);
			System.out.println("result Main : " + result);
			System.out.println("arr : " + arr[5]);

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
			System.out.println("Exception : " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Main exception : " + e.getMessage());
		}
	}
}