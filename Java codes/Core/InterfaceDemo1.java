package Core;

interface First {
	void disp();
}

interface Second extends First {
	void show();
}

abstract class Shape22 {
	abstract void draw();
}

class Rectangle22 extends Shape22 implements First {
	void draw() {
		System.out.println("Inside draw");
	}

	// uncomment the line 22
	public void disp() { };
	// void disp() { };
}

class InterfaceDemo1 {
	public static void main(String args[]) {
		Shape22 shape = new Rectangle22();
		shape.draw();
	}
}

/* Note: Identify the error, rectify it and get the output. */
