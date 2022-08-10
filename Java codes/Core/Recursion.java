package Core;
public class Recursion {
	public static void main(String a[]) {
		System.out.println(new Recursion().factorialMethod(4));
	}

	int factorialMethod(int n) {
		if (n == 1) {
			return 1;
		}
		return factorialMethod(n - 1) * n;
	}
}
