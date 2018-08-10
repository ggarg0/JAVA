abstract interface Shape{
	public void draw();
	public void draw1();
	//public void draw2();

}
abstract interface Shape1{
	public void draw();
	public void draw1();

}
class Rectangle implements Shape,Shape1{
	public void draw(){
		System.out.println("Drawing Rectangle");
	}
	public void draw1(){
			System.out.println("Drawing Rectangle1");
	}
}

class InterfaceDemo{
	public static void main(String args[]){
		Shape shape=new Rectangle();
		shape.draw1();
	}
}

/* Note: Identify the error, rectify it and get the output. */