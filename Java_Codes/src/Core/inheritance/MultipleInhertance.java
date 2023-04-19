package Core.inheritance;

class A {
	void msg() {
		System.out.println("Hello");
	}
}

class B {
	void msg() {
		System.out.println("Welcome");
	}
}

public class MultipleInhertance extends A {
	public static void main(String[] args) {
		MultipleInhertance obj = new MultipleInhertance();
		obj.msg();
	}
}
