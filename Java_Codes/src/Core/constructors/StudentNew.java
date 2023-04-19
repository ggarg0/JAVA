package Core.constructors;

class StudentNew {
	private int rollNumber = 34;
	private String name = "Jim";

	StudentNew() {
		System.out.println("Default Constructor");
		//rollNumber = 0;
		//name = "";
	}

	StudentNew(int rollNumber, String name) {
		System.out.println("OverLoaded Constructor");
		this.rollNumber = rollNumber;
		this.name = name;
	}

	void disp() {
		System.out.println("rollNumber =" + rollNumber);
		System.out.println("name =" + name);
	}

	public static void main(String arg[]) {
		StudentNew s2 = new StudentNew();
		s2.disp();
		StudentNew s1 = new StudentNew(101, "Jack");
		s1.disp();
		
	}
}

/*
 * Note: This program displays default values for object s1. Modify the program
 * to get the proper output
 */