interface First{
	void disp();
}
interface Second extends First{
	void show();
}

abstract class Shape{
	abstract void draw();
}

class Rectangle extends Shape implements First{
	void draw(){
		System.out.println("Inside draw");
	}
	void disp(){};
}

class InterfaceDemo1{
	public static void main(String args[]){
		Shape shape=new Rectangle();
		shape.draw();
	}
}

/* Note: Identify the error, rectify it and get the output. */
