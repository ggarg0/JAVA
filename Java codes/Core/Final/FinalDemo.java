package Core.Final;

class Parent {
	void disp() {
		System.out.println("Final disp method");
	}
}

class Child extends Parent {
	final void disp() {
		System.out.println("Child Final disp method");
	}
}

class FinalDemo {
	public static final void main(String args[]) {
		final Parent child = new Child();
		Parent child1;
		
		child.disp();
		child1 = child;
		child1.disp();
	}
}