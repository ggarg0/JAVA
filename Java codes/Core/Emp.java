class Emp
{
	private int empNumber;
	private String name;

Emp(int empNumber,String name)
{
	this.empNumber=empNumber;
	this.name=name;
}

void disp()
{
	System.out.println("empNumber ="+empNumber);
	System.out.println("name ="+name);
}
Emp getEmp()
{
	Emp emp=new Emp(30,"Tom");
	return emp;
}

public static void main(String arg[])
{
	Emp emp1=new Emp(10,"Mary");
	Emp emp2=new Emp(20,"Jerry");
	Emp emp3=emp1.getEmp();
	emp2=emp1;
	emp1.disp();
	emp2.disp();
	emp.disp();
}
}