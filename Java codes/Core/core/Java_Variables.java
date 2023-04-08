package Core.core;

public class Java_Variables {

	// instance variable is visible in Employee class only.
	public String name;
	private double salary;

	// DEPARTMENT is a constant
	public static final String COUNTRY = "India ";

	public void setSalary(double empSal) {
		salary = empSal;
	}

	public void setName(String empName) {
		name = empName;
	}

	public void printEmp() {
		String local = "LocalOne";
		System.out.println("name  : " + name);
		System.out.println("salary :" + salary);
		System.out.println("static Variable : " + COUNTRY);
		System.out.println("Local Variable : " + local);
	}

	public static void main(String args[]) {
		Java_Variables empOne = new Java_Variables();
		// empOne.setSalary(1000);
		empOne.setName("Java");
		empOne.printEmp();
	}
}
