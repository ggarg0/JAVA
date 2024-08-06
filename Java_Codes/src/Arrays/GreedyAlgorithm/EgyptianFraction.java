package Arrays.GreedyAlgorithm;

//https://www.educative.io/courses/algorithms-coding-interviews-java/solution-find-the-egyptian-fraction

public class EgyptianFraction {

	public static void printEgyptianFraction(int numerator, int denominator) {
		if (denominator == 0 || numerator == 0) {
			return;
		}
	
		if (denominator % numerator == 0) {
			System.out.print("1/" + denominator / numerator);
			return;
		}
	
		if (numerator % denominator == 0) {
			System.out.println(numerator / denominator);
			return;
		}
		
		if (numerator > denominator) {
			System.out.println(numerator / denominator + " , ");
			printEgyptianFraction(numerator % denominator, denominator);
			return;
		}
		
		int n = denominator / numerator + 1;
		System.out.print("1/" + n + " , ");
		printEgyptianFraction(numerator * n - denominator, denominator * n);
	}

	public static void main(String[] args) {
		int numerator = 2, denominator = 8;
		System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
		printEgyptianFraction(numerator, denominator);
		System.out.println();
	}
}
