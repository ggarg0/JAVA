package Core.abstraction;
abstract class Shape11{
	Shape11(){}
	//abstract void draw();
	void display(){
		System.out.println("Shape Hello");
	}
}
class Rectangle11 extends Shape11{
	void display(){
			System.out.println("Hello");
	}
	void draw(){
		System.out.println("Drawing Rectangle");
	}
}
class AbstractDemoTest{
	public static void main(String args[]){
		Shape11 s1=new Rectangle11();
		Rectangle11 s2=new Rectangle11();
		//s1.draw();
		s1.display();
		s2.draw();
		s2.display();
	}
}

/* Note: Analyze the program and understand the output. */
