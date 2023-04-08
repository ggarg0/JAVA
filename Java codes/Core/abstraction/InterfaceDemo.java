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
		System.out.println("Drawing Square from Shapes interface");
	}

	public void drawFromClass() {
		System.out.println("Drawing Square from drawFromClass");
	}

	public void fill() {
		System.out.println("Fill color");
	}

	public void drawSides() {
		System.out.println("Drawing sides from Shapes interface");
	}
}

class InterfaceDemo {
	public static void main(String args[]) {
		Shapes shape = new Square();
		shape.draw();
	}
}
