package Arrays.DivideAndConquer;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-review-1-euclidean-algorithm

public class EuclideanAlgorithm {

	public static int GCD(int a, int b) {
		if (a == 0)
			return b;
		
		return GCD(b % a, a);
	}

	public static void main(String[] args) {
		int a = 8;
		int b = 3;
		System.out.println("GCD(" + a + " , " + b + ") = " + GCD(a, b));

	}

}
