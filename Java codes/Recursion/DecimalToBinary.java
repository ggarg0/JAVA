package Recursion;

public class DecimalToBinary {
	public static int decimalToBinary(int decimalNum) {
		int result = -1;
		if (decimalNum == 0) {
			return 0;
		} else {
			result = (decimalNum % 2 + 10 * decimalToBinary(decimalNum / 2));
			return result;
		}
	}

	public static void main(String[] args) {
		int input = 27;
		int result = decimalToBinary(input);
		System.out.println("The binary form of " + input + " is: " + result);
	}
}
