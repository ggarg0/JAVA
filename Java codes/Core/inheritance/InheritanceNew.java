package Core.inheritance;

class StudentShow {
	public void disp() {
		System.out.println("Student Disp");
	}

	void show() {
		System.out.println("Student Show");
	}
}

class Perception extends StudentShow {
	public void display() {
		System.out.println("User Disp1");
	}

}

public class InheritanceNew {
	public static void main(String arg[]) {
		// PerceptionUser p1=new PerceptionUser();
		// Student p1 = new Student();
		// p1.disp();

		Perception p = new Perception();
		p.display();
	}
}