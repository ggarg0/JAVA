package Core.core;

class Java_Operators {
	public static void main(String arg[]) {

		// declare variables
		int a = 7, b = 5;
		System.out.println("a : " + a + " and b : " + b);
		
		// Assignment operator
		System.out.println("Assignment operator");
		System.out.println("=====================");
		int var;
		// assign value using =
		var = a;
		System.out.println("var using =: " + var);

		// assign value using =+
		var += a; 
		System.out.println("var using +=: " + var);

		// assign value using =*
		var *= a; 
		System.out.println("var using *=: " + var);

		// Arithmetic operator
		System.out.println();
		System.out.println("Arithmetic operator");
		System.out.println("=====================");
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("a / b = " + (a / b));

		// Relational operator
		System.out.println();
		System.out.println("Relational  operator");
		System.out.println("=====================");
		// == operator
		System.out.println(a == b); // false

		// != operator
		System.out.println(a != b); // true

		// > operator
		System.out.println(a > b); // true

		// < operator
		System.out.println(a < b); // false

		// >= operator
		System.out.println(a >= b); // true

		// <= operator
		System.out.println(a <= b); // false

		// Logical operator
		System.out.println();
		System.out.println("Logical operator");
		System.out.println("=====================");

		// && operator
		System.out.println((a > b) && (b > 0)); // true
		System.out.println((a < b) && (b > 5)); // false

		// || operator
		System.out.println((a > b) || (a < 0)); // true
		System.out.println((a < b) || (a > 0)); // true

		// ! operator
		System.out.println(!(a == b)); // true
		System.out.println(!(a > b)); //
		
		// Ternary Operator
		System.out.println( a + " and " + b);
		System.out.println("Ternary operator");
		System.out.println("=====================");
		System.out.println((6 > 9) ? "a > b" : "a < b");
		
		// increment operator
		System.out.println();
		System.out.println("Increment operator");
		System.out.println("=====================");
		int result1, result2;
	    result1 = ++a;
	    System.out.println("After increment: " + result1);
	   
	    // decrement operator
	    System.out.println();
	    System.out.println("Decrement operator");
	    System.out.println("=====================");
	    result2 = --b;
	    System.out.println("After decrement: " + result2);
		
	    // instanceof operator
	    System.out.println();
	    System.out.println("instanceof operator");
	    System.out.println("=====================");
	    String str = "Java";
	    System.out.println("Is str an object of String? " + str instanceof String);
	}
}