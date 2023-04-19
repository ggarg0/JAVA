package Core.abstraction;

interface First {
	void display();
}

interface Second extends First {
	void show();
}

abstract class Shape22 {
	abstract void draw();
}

class Rectangle22 extends Shape22 implements First, Second {
	void draw() {
		System.out.println("Inside draw");
	}

	public void display() {
		System.out.println("Inside display");
	}

	public void show() {
		System.out.println("Inside show");
	};

}

class InterfaceDemo1 {
	public static void main(String args[]) {
		Second shape = new Rectangle22();
		shape.display();
	}
}
