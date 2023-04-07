package Core.inheritance;

class Student {
	protected int rollNumber;
	protected String name;

	Student() {
		System.out.println("Parent class Default Constructor from Core.inheritance");
	}

	Student(int rno, String na) {
		rollNumber = rno;
		name = na;
		System.out.println("Parent overloaded constructor from Core.inheritance");
	}
}
