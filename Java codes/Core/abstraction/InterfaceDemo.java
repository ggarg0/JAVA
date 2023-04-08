package Core.abstraction;

abstract interface Shapes {
	public void draw();
//	public void drawSides();
}

abstract interface color {
	public void fill();
}

class Square implements Shapes, color {
	public void draw() {
		System.out.println("Drawing Square");
	}

	public void drawFromClass() {
		System.out.println("Drawing Square from drawFromClass");
	}

	public void fill() {
		System.out.println("Fill color");
	}

	public void drawSides() {
		System.out.println("Drawing sides");
	}
}

class InterfaceDemo {
	public static void main(String args[]) {
		Shapes shape = new Square();
		shape.draw();

		color color = new Square();
		color.fill();

		Square square = new Square();
		square.draw();
		square.drawFromClass();
		square.fill();
		square.drawSides();
	}
}
