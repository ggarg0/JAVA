package Core.core;

public class Java_ClassExample {
	// defining the variables of class
	int a = 20;
	int b = 10;
	int c;

	// defining the methods of class
	public void add() {
		int c = a + b;
		System.out.println("Addition of numbers is: " + c);
	}

	public void sub() {
		int c = a - b;
		System.out.println("Subtraction of numbers is: " + c);
	}

// main method  
	public static void main(String[] args) {
		// creating the object of class
		Java_ClassExample obj = new Java_ClassExample();

		// calling the methods
		obj.add();
		obj.sub();
	}
}
