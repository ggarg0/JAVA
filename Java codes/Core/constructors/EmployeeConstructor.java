package Core.constructors;

class Employee {
	private int empId;
	private String empName;
	private String email;

	public Employee() {
		System.out.println("Default");
	}

	public Employee(String email) {
		this.email = email;
	}

	public Employee(int empId, String empName) {
		// this(empId, empName, "companyMail");
		this("companyMail");
		this.empId = empId;
		this.empName = empName;
	}

	public Employee(int empId, String empName, String email) {
		this.empId = empId;
		this.empName = empName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

public class EmployeeConstructor {
	public static void main(String[] args) {

		Employee obj1 = new Employee();
		System.out.println(obj1.toString());

		Employee obj = new Employee();
		obj.setEmpId(100);
		obj.setEmpName("100");
		System.out.println(obj.toString());

		Employee obj3 = new Employee(200, "200", "200@gmail.com");
		System.out.println(obj3.toString());

		Employee obj4 = new Employee(400, "400");
		Employee obj5 = new Employee(500, "500");
		System.out.println(obj4.toString());
		System.out.println(obj5.toString());
	}
}
