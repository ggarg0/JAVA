package Core.core;

public class LoopStatement {

	public static void main(String[] args) {

		// for statement
		System.out.println("for loop");
		System.out.println("=====================");
		for (int i = 0; i <= 10; i++) {
			System.out.print("| " + i + " | ");
		}
		System.out.println();

		// for each statement
		System.out.println();
		System.out.println("for each loop");
		System.out.println("=====================");
		int arr[] = { 10, 50, 60, 80, 90 };
		for (int element : arr)
			System.out.print(element + " ");

		System.out.println();

		// while statement
		System.out.println();
		System.out.println("while loop");
		System.out.println("=====================");
		int a = 1;
		// test expression
		while (a > 0) {
			System.out.println("Hello World");
			a--;
		}

		// do while statement
		System.out.println();
		System.out.println("do while loop");
		System.out.println("=====================");
		int b = 0;
		do {
			System.out.println("Print statement");
			b--;
		} while (b > 0);
	}

}
