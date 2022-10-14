package Recursion;

public class PowerNum {

	public static int power(int x, int n) {
		if (n == 1)
			return x;

		return (power(x, n - 1) * x);
	}

	public static void main(String[] args) {
		System.out.println(power(2, 3));
	}
}
