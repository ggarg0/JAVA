package Core;
 class Student{
	protected int rollno=12;
	protected String name;
	Student(){
		System.out.println("Student Base constructor");
	}
	Student(int rollno,String name){
		this.rollno=rollno;
		this.name=name;
		System.out.println("Student Parameter constructor - Roll No : "+ rollno + " and Name : "+ name);
	}
	void show()
	{
		System.out.println("Student Show");
	}
}
 class PerceptionUser extends Student{
	String title;
	PerceptionUser(){
		System.out.println("PerceptionUser Base Constructor");
	}
	PerceptionUser(int rollno,String name, String title){
		super(rollno,name);
		System.out.println("PerceptionUser Parameter constructor - Roll No : "+ rollno + ", Name : "+ name + " and Title : "+ title);
	}
	void display()
		{
			System.out.println("PerceptionUser display");
	}
}
class Constructor{
	public static void main(String args[]){
		//PerceptionUser p=new PerceptionUser();
		//PerceptionUser p1=new PerceptionUser(101,"Sam","TL");
		//Student p2=new Student(101,"Jack");
		Student p3=new PerceptionUser(1001,"Mark","PM");
		p3.show();
	//	p3.display(); // Compilation Error : cannot find symbol p3.display() due to run time polymorphism
	}
}
