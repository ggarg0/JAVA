package Core;
class Parent1{
		protected int number=10;
}

class Child1 extends Parent1{
	private int number=100;

	public void disp(){
		System.out.println(number);
		System.out.println(super.number);
	}
}

class SuperDemo{
	public static void main(String args[]){
		Child1 child=new Child1();
		child.disp();
	}
}

/* Note: Analyze the code and understand the output. */