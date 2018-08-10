class Factorial
{
	int factorialMethod(int n)
	{
		int fact=0;;
		if(n==1){

			return 1;
		}
		fact=factorialMethod(n-1) * n;
		return fact;


	}
}
public class Recursion
{
	public static void main(String a[])
	{
	Factorial f= new Factorial();
	System.out.println(f.factorialMethod(5));
	}

}
