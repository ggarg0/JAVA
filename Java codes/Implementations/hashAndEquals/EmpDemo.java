package hashAndEquals;

public class EmpDemo {
	public static void main(String[] a) {
		Employee e1 = new Employee(21,"gaurav");
		Employee e2 = new Employee(21,"gaurav");
		
		System.out.println("Hash : " + e1.hashCode());
		System.out.println("Hash : " + e2.hashCode());
		System.out.println("Equals : " + e1.equals(e2));
}
}
