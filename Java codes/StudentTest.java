class Student
{
	private int rollNumber=10;
	private String name="wqe";

void setStudent(int rollNumber,String name)
{
	rollNumber=rollNumber;
	this.name=name;
}

public void disp()
{
	System.out.println("rollNumber ="+rollNumber);
	System.out.println("name ="+name);
}
}

public class StudentTest
{
public static void main(String arg[])
{
	Student s1=new Student();
	Student s2=new Student();
	s1.disp();
	s1.setStudent(101,"Jack");
	s2.setStudent(102,"Tom");
	s1.disp();
	s2.disp();
}
}
