package Java8;

@FunctionalInterface
interface Addable {
	int add(int a, int b);

	default String show() {
		return "Default method";
	}

	static String display() {
		return "Static method";
	}
}

public class LambdaFunctionalInterface {
	public static void main(String[] args) {

		// Multiple parameters in lambda expression
		Addable ad1 = (a, b) -> (a + b);
		System.out.println(ad1.add(15, 20));

		// Multiple parameters with data type in lambda expression
		Addable ad2 = (int a, int b) -> (a + b);
		System.out.println(ad2.add(12, 20));
		System.out.println(ad2.show());
		System.out.println(Addable.display());
	}
}