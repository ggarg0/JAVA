class Student
{
	public void disp()
		{
			System.out.println("Student Disp");

		}
		private void show()
			{
				System.out.println("Student Show");
			}
}

class PerceptionUser extends Student
{
	public void disp()
			{
				System.out.println("User Disp1");

			}
			void show()
				{
					System.out.println("User Show");
			}
}
public class InheritanceNew{
	public static void main(String arg[])	{
		PerceptionUser p=new PerceptionUser();
		//Student p=new PerceptionUser();
		//Student p=new Student();
		p.disp();
		p.show();
	}
}