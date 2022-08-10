package Core;
abstract class Shape{
	abstract void draw();
}

class Rectangle extends Shape{
	void draw(){
		System.out.println("Drawing Rectangle");
	}
}

class Traingle extends Shape{
	void draw(){
		System.out.println("Drawing Traingle");
	}
}

class AbstractDemo{
	public static void main(String args[]){
		Shape s1=new Rectangle();
		s1.draw();
		s1=new Traingle();
		s1.draw();
	}
}

/* Note: Identify the error, rectify it and get the output */