package Core.core;

public class Java_Employee {

	private int empNo;
	private String empName;
	private String empEmail;
	private String empCountry;

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empEmail=" + empEmail + ", empCountry="
				+ empCountry + "]";
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpCountry() {
		return empCountry;
	}

	public void setEmpCountry(String empCountry) {
		this.empCountry = empCountry;
	}

	public static void main(String[] args) {
		Java_Employee object = new Java_Employee();
		object.setEmpNo(100);
		object.setEmpName("Test");
		object.setEmpEmail("abc.com");
		object.setEmpCountry("India");

		System.out.println(object.toString());

		object.empNo = 111;
		object.empName = "Test me";
		object.empCountry = "US";
		System.out.println(object.toString());
	}
}
