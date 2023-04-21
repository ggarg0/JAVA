package Core.Final;

class Parent {
	final static int value = 10;

	void show() {
		System.out.println("Parent show method");
	}
}

class Child extends Parent {
	void show() {
		System.out.println("Child show method" + Parent.value);
	}
}

class FinalDemo {
	public static final void main(String args[]) {
		final Parent child = new Child();
		child.show();
		// child = new Parent();
		String obj = new String();
	}
}