class Parent{
	 void disp(){
		System.out.println("Final disp method");
	}
}

class Child extends Parent{
	void disp(){
		System.out.println("Child Final disp method");
	}
}

class FinalDemo{
	public static final void main(String args[]){
		Parent child=new Child();
		child.disp();
	}
}

/* Note: Identify the error, rectify it and get the output. */