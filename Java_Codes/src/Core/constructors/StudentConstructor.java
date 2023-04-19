package Core.constructors;

class StudentConstructor {
	private int rollNumber;
	private String name;

	StudentConstructor(int rollNumber, String name) {
		System.out.println("Parameterized constructor");
		this.rollNumber = rollNumber;
		this.name = name;
	}

	StudentConstructor() {
		this(10,"Abc");
		System.out.println("Base constructor");
	}

	void disp() {
		System.out.println("rollNumber =" + rollNumber);
		System.out.println("name =" + name);
	}

	public static void main(String arg[]) {
	//	StudentConstructor s1 = new StudentConstructor(101, "Jack");
	//	s1.disp();
		StudentConstructor s2 = new StudentConstructor();
		s2.disp();
	}
}