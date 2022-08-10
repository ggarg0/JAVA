package Core;
abstract class Student99{
	protected String name;
	Student99(){
		System.out.println("Student Base constructor");
	}
	Student99(String name){
		System.out.println("Student parameter constructor");
	}
}

class PerceptionUser99 extends Student99{
	String password;
	PerceptionUser99(){
		System.out.println("PerceptionUser Base Constructor");
	}
	PerceptionUser99(String name, String pwd){
		super(name);
		System.out.println("PerceptionUser parameter constructor");
	}
}
class ConstructorDemo{
	public static void main(String args[]){
	//	Student s = new Student();
		Student99 s1 = new PerceptionUser99();
		PerceptionUser99 p=new PerceptionUser99();
		PerceptionUser99 p1=new PerceptionUser99("jack","infy@123");
	}
}
