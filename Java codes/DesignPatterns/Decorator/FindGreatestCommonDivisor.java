package DesignPatterns.Decorator;

public class FindGreatestCommonDivisor {

	public static int findGreatestCommonDivisor(int x, int y) {

		if (x == y)
			return x;

		if (x > y) {
			return findGreatestCommonDivisor(x - y, y);
		} else {
			return findGreatestCommonDivisor(x, y - x);
		}

	}

	public static void main(String[] args) {
		int x = 85;
		int y = 68;
		int result = findGreatestCommonDivisor(x, y);
		System.out.println("The GCD of " + x + " and " + y + " is : " + result);

	}
}