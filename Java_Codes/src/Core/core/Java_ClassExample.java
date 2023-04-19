package Core.core;

public class Java_ClassExample {
	// defining the variables of class
	int a = 20;
	int b = 10;
	
	// defining the methods of class
	public void add() {
		int add = a + b; // local variable
		System.out.println("Addition of numbers is: " + add);
	}
	
	public void sub() {
		int sub = a - b;
		System.out.println("Subtraction of numbers is: " + sub);
	}
	
	public void mul() {
		int mul = a * b;
		System.out.println("Mul of numbers is: " + mul);
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
