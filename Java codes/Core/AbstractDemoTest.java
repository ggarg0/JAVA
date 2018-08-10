abstract class Shape{
	Shape(){}
	//abstract void draw();
	void display(){
		System.out.println("Shape Hello");
	}
}
class Rectangle extends Shape{
	void display(){
			System.out.println("Hello");
	}
	void draw(){
		System.out.println("Drawing Rectangle");
	}
}
class AbstractDemoTest{
	public static void main(String args[]){
		Shape s1=new Rectangle();
		Rectangle s2=new Rectangle();
		//s1.draw();
		s1.display();
		s2.draw();
		s2.display();
	}
}

/* Note: Analyze the program and understand the output. */
