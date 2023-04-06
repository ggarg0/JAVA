package Core.inheritance;

class Student11 {
	protected int rollno;
	protected String name;

	Student11() {
		System.out.println("Parent class Default Constructor");
	}

	Student11(int rno, String na) {
		rollno = rno;
		name = na;
		System.out.println("Parent overloaded constructor");
	}
}

class PerceptionUser11 extends Student11 {
	String password;

	PerceptionUser11() {
		System.out.println("Child class Default Constructor");
	}

	PerceptionUser11(String pwd) {
		super(123, "GAUARVA");
		password = pwd;
		System.out.println("Child class overloaded Constructor");
	}

	void disp() {
		System.out.println(rollno);
		System.out.println(name);
		System.out.println(password);
	}
}

class Inheritance {
	public static void main(String arg[]) {
		PerceptionUser11 p = new PerceptionUser11("infy@123");
		p.disp();
	}
}