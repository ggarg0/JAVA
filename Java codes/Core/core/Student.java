package Core.core;

class Student1 {
	private int rollNumber;
	private String name;

	void setStudent(int rno, String sname) {
		rollNumber = rno;
		name = sname;
	}

	private void disp() {
		System.out.println("rollNumber =" + rollNumber);
		System.out.println("name =" + name);
	}

	public static void main(String arg[]) {
		Student1 s1 = new Student1();
		Student1 s2 = new Student1();
		s1.disp();
		s1.setStudent(101, "Jack");
		s2.setStudent(102, "Tom");
		s1.disp();
		s2.disp();
	}

}