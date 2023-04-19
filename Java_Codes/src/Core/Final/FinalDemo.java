package Core.Final;

class Parent {
	void show() {
        System.out.println("Parent show method");
    }
}

class Child extends Parent {
     void show() {
        System.out.println("Child show method");
    }
}

class FinalDemo {
    public static final void main(String args[]) {
        final Parent child = new Child();
		String obj = new String();
        child.show();
       // child = new Parent();
    }
}