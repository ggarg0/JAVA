package Core.inheritance;

class Student55 {
	public void disp() {
		System.out.println("Student Disp");

	}

	private void show() {
		System.out.println("Student Show");
	}
}

class PerceptionUser55 extends Student55 {
	public void disp() {
		System.out.println("User Disp1");

	}

	void show() {
		System.out.println("User Show");
	}
}

public class InheritanceNew {
	public static void main(String arg[]) {
		PerceptionUser55 p = new PerceptionUser55();
		// Student p=new PerceptionUser();
		// Student p=new Student();
		p.disp();
		p.show();
	}
}