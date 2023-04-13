package Core.abstraction;

interface One {
	void draw();
}

interface Two {
	void draw();
}

class Show implements One, Two {
	public void draw() {
		System.out.println("Inside draw");
	}

	private void draw1() {
		System.out.println("Inside draw1");
	}
}

class InterfaceDemoNew {
	public static void main(String args[]) {
		Show shape = new Show();
		shape.draw();
	}
}