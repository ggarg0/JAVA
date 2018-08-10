interface Rectangle{
	void draw();
}

abstract class Shape{
	abstract void draw();
}

class Square extends Shape implements Rectangle{
	public void draw(){
		System.out.println("Inside draw");
	}
	private void draw1(){
			System.out.println("Inside draw");
	}
}

 class InterfaceDemoNew{
	public static void main(String args[]){
		Shape shape=new Square();
		shape.draw();
	}
}

/* Note: Analyze the code and undersatnd the output. */