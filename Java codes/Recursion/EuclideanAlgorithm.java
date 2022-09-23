package Recursion;

public class EuclideanAlgorithm {

	public static int GCD(int a, int b) {
		if (a == 0)
			return b;
		return GCD(b % a, a);
	}

	public static void main(String[] args) {
		int a = 85;
		int b = 68;
		System.out.println("GCD(" + a + " , " + b + ") = " + GCD(a, b));

	}

}
