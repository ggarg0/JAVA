class Student
{
	protected int rollno;
	protected String name;
Student()
	{
		System.out.println("Parent class Default Constructor");
	}

	Student(int rno,String na)
	{
				rollno=rno;
				name=na;
				System.out.println("Parent overloaded constructor");
	}
}

class PerceptionUser extends Student
{
	String password;

	PerceptionUser()
	{
		System.out.println("Child class Default Constructor");
	}
	PerceptionUser(String pwd)
	{
		super(123,"GAUARVA");
		password=pwd;
		System.out.println("Child class overloaded Constructor");
	}
	void disp()
	{
				System.out.println(rollno);
				System.out.println(name);
				System.out.println(password);
	}
}
class Inheritance{
	public static void main(String arg[])	{
		PerceptionUser p=new PerceptionUser("infy@123");
		p.disp();
	}
}