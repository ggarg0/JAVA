abstract class Student{
	protected String name;
	Student(){
		System.out.println("Student Base constructor");
	}
	Student(String name){
		System.out.println("Student parameter constructor");
	}
}

class PerceptionUser extends Student{
	String password;
	PerceptionUser(){
		System.out.println("PerceptionUser Base Constructor");
	}
	PerceptionUser(String name, String pwd){
		super(name);
		System.out.println("PerceptionUser parameter constructor");
	}
}
class ConstructorDemo{
	public static void main(String args[]){
	//	Student s = new Student();
		Student s1 = new PerceptionUser();
		PerceptionUser p=new PerceptionUser();
		PerceptionUser p1=new PerceptionUser("jack","infy@123");
	}
}
