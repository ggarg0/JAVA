package Core.inheritance;

class Student33 {
	protected int rollno;
	protected String name;

	Student33() {
		System.out.println("Parent class Default Constructor");
	}

	Student33(int rno, String na) {
		rollno = rno;
		name = na;
		System.out.println("Parent overloaded constructor");
	}
}

class PerceptionUser33 extends Student33 {
	String password;

	PerceptionUser33() {
		System.out.println("Child class Default Constructor");
	}

	PerceptionUser33(String pwd) {
		password = pwd;
		System.out.println("Child class overloaded Constructor");
	}

	PerceptionUser33(int rollno, String name, String pwd) {
		this.rollno = rollno;
		this.name = name;
		password = pwd;
		System.out.println("Child class, Overloaded constructor for initializing all");
	}

	void disp() {
		System.out.println(rollno);
		System.out.println(name);
		System.out.println(password);
	}
}

class InheritanceDemo {
	public static void main(String arg[]) {
		PerceptionUser33 p1 = new PerceptionUser33("infy@123");
		p1.disp();
		PerceptionUser33 p2 = new PerceptionUser33(101, "Jack", "infy@123");
		p2.disp();
	}
}