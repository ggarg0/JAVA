
class tryCatch{

public int divide(int a)
{
	int b=0;
	b = 10/a;
	return b;
}


public static void main(String[] a)
{
	try{
		tryCatch obj = new tryCatch();
		int result = obj.divide(1);
		System.out.println("result Main : " + result);

	}catch(Exception e)
	{
		System.out.println("Divide by Zero 1..... ");
	}
}
}