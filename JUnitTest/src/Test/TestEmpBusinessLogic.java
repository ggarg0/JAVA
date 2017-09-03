package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.gaurav.junit.EmpBusinessLogic;
import com.gaurav.junit.EmployeeDetails;

public class TestEmpBusinessLogic {

	EmpBusinessLogic empBusinessLogic;
	EmployeeDetails employee;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("in before class");
	}

	@Before
	public void before() {
		System.out.println("Instantiating Object ... ");
		empBusinessLogic = new EmpBusinessLogic();
		employee = new EmployeeDetails();
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("in after class");
	}

	@After
	public void after() {
		System.out.println("Deleting Object ... ");
		empBusinessLogic = null;
		employee = null;
	}

	@Test
	public void testCalculateYearlySalary() {

		double salary = empBusinessLogic.calculateYearlySalary(employee);
		System.out.println("salary ... " + salary);
		assertEquals(96000, salary,0.0);
	}

	@Test(timeout = 1)
	public void testCalculateAppraisal() {

		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		System.out.println("appraisal ... " + appraisal);
		assertEquals(500, appraisal, 0.0);

	}

	@Ignore("Not Ready to Run")
	@Test(expected = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
	}

}
