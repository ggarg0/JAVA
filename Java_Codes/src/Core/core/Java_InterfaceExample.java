package Core.core;

interface CalcInterface {
	void multiply();
	void divide();
	void add();
}

interface CalcInterface1 {
	void sub();
}

public class Java_InterfaceExample implements CalcInterface1,CalcInterface  {

	// defining the variables of class
	int a = 100;
	int b = 20;
	int c;

	// implementing the interface methods
	public void multiply() {
		int c = a * b;
		System.out.println("Multiplication of numbers is: " + c);
	}

	public void divide() {
		int c = a / b;
		System.out.println("Division of numbers is: " + c);
	}
	
	public void add() {
		int c = a + b;
		System.out.println("Add of numbers is: " + c);
	}
	
	public void sub() {
		int c = a - b;
		System.out.println("Sub of numbers is: " + c);
	}

	// main method  
	public static void main(String[] args) {
		Java_InterfaceExample obj = new Java_InterfaceExample();
		// calling the methods
		
		obj.multiply();
		obj.divide();
		System.out.println(obj instanceof CalcInterface1);
	}

}
