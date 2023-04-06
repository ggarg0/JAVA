package Core.exceptionhandling;

import java.util.ArrayList;
import java.util.List;

class TryCatch {
	public int divide(int a) {
		int b = 0;
		b = 10 / a;
		return b;
	}

	public static void main(String[] a) {
		try {
			TryCatch obj = new TryCatch();
			List<Object> list = new ArrayList<Object>();
			list.get(2);
			int result = obj.divide(0);
			System.out.println("result Main : " + result);

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
			System.out.println("Divide by Zero : " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Main exception : " + e.getMessage());
		}
	}
}