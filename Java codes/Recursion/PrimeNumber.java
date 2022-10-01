package Recursion;

public class PrimeNumber {

	public static boolean isPrime(int num, int i) {
		if (num < 2)
			return false;
		else if (i == 1)
			return true;
		else if (num % i == 0)
			return false;
		else
			return isPrime(num, i - 1);
	}

	public static void main(String[] args) {
		int input = 3;
		boolean result = isPrime(input, input / 2);
		if (result == true) {
			System.out.println(input + " is a prime number");
		} else {
			System.out.println(input + " is NOT a prime number");
		}
	}

}
