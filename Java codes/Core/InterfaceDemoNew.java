package Core;
interface Rectangle77{
	void draw();
}

abstract class Shape77{
	abstract void draw();
}

class Square77 extends Shape77 implements Rectangle77{
	public void draw(){
		System.out.println("Inside draw");
	}
	private void draw1(){
			System.out.println("Inside draw");
	}
}

 class InterfaceDemoNew{
	public static void main(String args[]){
		Shape77 shape=new Square77();
		shape.draw();
	}
}

/* Note: Analyze the code and undersatnd the output. */