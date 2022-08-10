package Core;
class Student111 {
	protected int rollno;
	protected String name;

	Student111() {
		System.out.println("Parent simple constructor");

	}

	Student111(int rno, String na) {
		rollno = rno;
		name = na;
		System.out.println("Parent overloaded constructor");
	}
}

class PerceptionUser111 extends Student111 {
	String password;

	PerceptionUser111() {
		System.out.println("PerceptionUser simple constructor");

	}

	PerceptionUser111(int rollno, String name, String pwd) {
		// When you are invoking the parent class constructor super should be the first
		// statement
		super(rollno, name);
		password = pwd;
		System.out.println("Child class overloaded Constructor");
	}

	void disp() {
		System.out.println(rollno);
		System.out.println(name);
		System.out.println(password);
	}
}

class SuperConstructor {
	public static void main(String args[]) {
		// PerceptionUser p=new PerceptionUser(101,"jack","infy@123");
		// PerceptionUser p=new PerceptionUser();
		PerceptionUser111 p = new PerceptionUser111();
		// p.disp();
	}
}

/*
 * Modify this program add a disp() method in the parent class to display
 * rollnumber and name. invoke the disp() method from the child class disp()
 * method using super.disp()
 */
