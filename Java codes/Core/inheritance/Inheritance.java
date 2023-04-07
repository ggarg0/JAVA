package Core.inheritance;


class PerceptionStudent extends Student {
	String password;

	PerceptionStudent() {
		System.out.println("Child class Default Constructor");
	}

	PerceptionStudent(String pwd) {
		super(123, "GAUARV");
		password = pwd;
		System.out.println("Child class overloaded Constructor");
	}

	void disp() {
		System.out.println(rollNumber);
		System.out.println(name);
		System.out.println(password);
	}
}

class Inheritance {
	public static void main(String arg[]) {
		PerceptionStudent p = new PerceptionStudent("password");
		p.disp();
	}
}