package Core.inheritance;

class Student {
	protected int rollno;
	protected String name;

	Student() {
		System.out.println("Parent simple constructor");

	}

	Student(int rno, String na) {
		rollno = rno;
		name = na;
		System.out.println("Parent overloaded constructor");
	}
}

class PerceptionUser extends Student {
	String password;

	PerceptionUser() {
		System.out.println("PerceptionUser simple constructor");

	}

	PerceptionUser(int rollno, String name, String pwd) {
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
		PerceptionUser p = new PerceptionUser(101, "jack", "infy@123");
		PerceptionUser p1 = new PerceptionUser();
		p1.disp();
	}
}
