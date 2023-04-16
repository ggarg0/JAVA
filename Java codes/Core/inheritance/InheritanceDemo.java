package Core.inheritance;

import Core.core.Student;

class PerceptionUsers extends Student {
	String password;

	PerceptionUsers() {
		System.out.println("Child class Default Constructor");
	}

	PerceptionUsers(String pwd) {
		password = pwd;
		System.out.println("Child class overloaded Constructor");
	}

	PerceptionUsers(int rollno, String name, String pwd) {
		this.rollNumber = rollno;
		this.name = name;
		password = pwd;
		System.out.println("Child class, Overloaded constructor for initializing all");
	}

	public void disp() {
		System.out.println(rollNumber + ", " + name + ", " + password);
	}
}

class InheritanceDemo {
	public static void main(String arg[]) {
		PerceptionUsers p1 = new PerceptionUsers("password");
		p1.disp();
		PerceptionUsers p2 = new PerceptionUsers(101, "Jack", "password");
		p2.disp();
	}
}