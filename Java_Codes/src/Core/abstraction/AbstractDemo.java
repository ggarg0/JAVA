package Core.abstraction;

abstract class Shape {
	abstract void draw();

	void draw1() {
		System.out.println("Drawing Rectangle shape");
	}
}

class Rectangle extends Shape {
	void draw() {
		System.out.println("Drawing Rectangle");
	}
}

class Traingle extends Shape {
	void draw() {
		System.out.println("Drawing Traingle");
	}

	void display() {
		System.out.println("Drawing Traingle display");
	}
}

class AbstractDemo {
	public static void main(String args[]) {
		Shape s1 = new Rectangle();
		s1.draw1();
		Traingle s2 = new Traingle();
		s2.draw();
	}
}
