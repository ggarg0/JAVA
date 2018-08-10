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
		password=pwd;
		System.out.println("Child class overloaded Constructor");
	}

	PerceptionUser(int rollno,String name,String pwd)
	{
			this.rollno=rollno;
			this.name=name;
			password=pwd;
			System.out.println("Child class, Overloaded constructor for initializing all");
	}

	void disp()
	{
				System.out.println(rollno);
				System.out.println(name);
				System.out.println(password);
	}
}
class InheritanceDemo{
	public static void main(String arg[])	{
		PerceptionUser p1=new PerceptionUser("infy@123");
		p1.disp();
		PerceptionUser p2=new PerceptionUser(101,"Jack","infy@123");
		p2.disp();
	}
}