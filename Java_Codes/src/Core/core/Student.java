package Core.core;

public class Student {
	protected int rollNumber;
	protected String name;

	public Student() {
		System.out.println("Parent class Default Constructor from Core.core");
	}

	public Student(int rno, String na) {
		rollNumber = rno;
		name = na;
		System.out.println("Parent overloaded constructor from Core.core");
	}

	void setStudent(int rno, String sname) {
		rollNumber = rno;
		name = sname;
	}

	public void disp() {
		System.out.println("rollNumber =" + rollNumber);
		System.out.println("name =" + name);
	}

	public static void main(String arg[]) {
		Student s1 = new Student();
		Student s2 = new Student();
		s1.disp();
		s1.setStudent(101, "Jack");
		s2.setStudent(102, "Tom");
		s1.disp();
		s2.disp();
	}

}