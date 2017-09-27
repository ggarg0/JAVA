class Student{
	protected int rollno;
	protected String name;
	abstarct Student(){

					System.out.println("Base constructor");
	}
	Student(int rno,String na){

				System.out.println("parameter constructor");
	}
}

class PerceptionUser extends Student{
	String password;
	PerceptionUser(){

		System.out.println("Per Base Constructor");
	}
	PerceptionUser(int rollno,String name, String pwd){
super(rollno,name);
		System.out.println(" perv parameter constructor");
	}

}

class Constructor{
	public static void main(String args[]){
		PerceptionUser p=new PerceptionUser();
		PerceptionUser p1=new PerceptionUser(101,"jack","infy@123");

	}
}
