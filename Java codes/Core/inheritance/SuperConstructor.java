package Core.inheritance;

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
		System.out.println(rollNumber);
		System.out.println(name);
		System.out.println(password);
	}
}

class SuperConstructor {
	public static void main(String args[]) {
		PerceptionUser p = new PerceptionUser(101, "jack", "password");
		PerceptionUser p1 = new PerceptionUser();
		p1.disp();
	}
}
