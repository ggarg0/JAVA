class Parent{
		protected int number=10;
}

class Child extends Parent{
	private int number=100;

	public void disp(){
		System.out.println(number);
		System.out.println(super.number);
	}
}

class SuperDemo{
	public static void main(String args[]){
		Child child=new Child();
		child.disp();
	}
}

/* Note: Analyze the code and understand the output. */