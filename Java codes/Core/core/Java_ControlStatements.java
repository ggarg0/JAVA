package Core.core;

public class Java_ControlStatements {

	public static void main(String[] args) {

		// If statement
		System.out.println("if statement");
		System.out.println("=====================");
		int i = 10;
		if (i > 15) 
			System.out.println("Inside If block");		
			
		System.out.println("10 is less than 15");
		

		// If else statement
		System.out.println();
		System.out.println("If else statement");
		System.out.println("=====================");
		if (i < 15)
			System.out.println("i is smaller than 15");
		else
			System.out.println("i is greater than 15");

		// Nested If else statement
		System.out.println();
		System.out.println("Nested If statement");
		System.out.println("=====================");
		if (i == 10 || i > 15) {
			if (i < 15)
				System.out.println("i is smaller than 15");

			if (i < 12)
				System.out.println("i is smaller than 12 too");
		} else {
			System.out.println("i is greater than 15");
		}

		// If else if statement
		System.out.println();
		System.out.println("If else if statement");
		System.out.println("=====================");
		int j = 23;
		if (j == 10)
			System.out.println("j is 10");
		else if (j == 15)
			System.out.println("j is 15");
		else if (j == 20)
			System.out.println("j is 20");
		else
			System.out.println("j is not present");

		// switch statement
		System.out.println();
		System.out.println("switch statement");
		System.out.println("=====================");
		int num = 15;
		switch (num) {
		case 5:
			System.out.println("It is 5");
			break;
		case 10:
			System.out.println("It is 10");
			break;
		case 15:
			System.out.println("It is 15");
			break;
		case 20:
			System.out.println("It is 20");
			break;
		default:
			System.out.println("Not present");
		}
	}

}
