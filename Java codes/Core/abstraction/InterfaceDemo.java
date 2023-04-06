package Core.abstraction;

abstract interface Shape55 {
	public void draw();

	public void draw1();
	// public void draw2();

}

abstract interface Shape56 {
	public void draw();

	public void draw1();

}

class Rectangle55 implements Shape55, Shape56 {
	public void draw() {
		System.out.println("Drawing Rectangle");
	}

	public void draw1() {
		System.out.println("Drawing Rectangle1");
	}
}

class InterfaceDemo {
	public static void main(String args[]) {
		Shape55 shape = new Rectangle55();
		shape.draw1();
	}
}

/* Note: Identify the error, rectify it and get the output. */