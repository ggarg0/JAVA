package Core.core;

public class Java_LoopStatement {

	public static void main(String[] args) {

		// for statement
		System.out.println("for loop");
		System.out.println("=====================");
		for (int i = 0; i <= 10; i++)
			System.out.print("| " + i + " | ");

		System.out.println();

		// for each statement
		System.out.println();
		System.out.println("for each loop");
		System.out.println("=====================");
		int arr[] = { 10, 50, 60, 80, 90 };

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println("*********");
		for (int element : arr)
			System.out.print(element + " ");

		System.out.println();

		// while statement
		System.out.println();
		System.out.println("while loop");
		System.out.println("=====================");
		int a = 0;
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

		// continue statement
		System.out.println();
		System.out.println("continue statement");
		System.out.println("=====================");
		for (int i = 0; i < 10; i++) {
			if (i == 4 || i == 7) 
				continue;
			
			System.out.print(i + "  ");
		}
		System.out.println();

		// break statement
		System.out.println();
		System.out.println("break statement");
		System.out.println("=====================");
		for (int i = 0; i < 10; i++) {
			if (i == 5)
				break;

			System.out.print(i + "  ");
		}
		System.out.println();

		// return statement
		System.out.println();
		System.out.println("return statement");
		System.out.println("=====================");
		System.out.println("Sum : " + sum(4, 5));

	}

	static int sum(int a, int b) {
		int sum = 0;
		
		if(a == 0)
			return 0;
		
		sum = (a + b);
		return sum;
	}
}
