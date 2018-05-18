import java.util.Arrays;

public class ArrayNumberCloseToZero {

	public static void main(String[] a) {

		int[] array = { 5, -2, -1, 1, 12 };
		Arrays.sort(array);
		int num = array[0];
		int absNum = Math.abs(num);
	System.out.println("absNum : " + absNum);
		for (int i = 1; i < array.length; ++i) {
			int newAbs = Math.abs(array[i]);
			System.out.println("newAbs : " + newAbs);
			if (newAbs < absNum) {
				absNum = newAbs;
				num = array[i];
			}
		}
		System.out.println("Number : " + num);
	}
}
