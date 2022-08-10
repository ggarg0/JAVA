package Core;
class StudentConstructor
{
	private int rollNumber;
	private String name;

StudentConstructor(int rollNumber,String name)
{
	this.rollNumber=rollNumber;
	this.name=name;
}
StudentConstructor()
{
	System.out.println("base constructor");
}
void disp()
{
	System.out.println("rollNumber ="+rollNumber);
	System.out.println("name ="+name);
}

public static void main(String arg[])
{
	StudentConstructor s1=new StudentConstructor(101,"Jack");
	StudentConstructor s2=new StudentConstructor();
	s1.disp();
	s2.disp();
}
}