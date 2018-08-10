class NumberTest {
	private int num;
	public int divide(int n)  {
		int a=0;
		int b=100;
		try{
			a=10/n;
			return a;
		}catch(ArithmeticException e){
			throw e;
			//return a;
		}
		/*finally{
			return b;
		}*/
	}
}
public class ThrowsDemo {
	public static void main( String args[]){
		try{
		NumberTest ob = new NumberTest();
		int ret = ob.divide(0);
		System.out.println("ret : " + ret);
	}
	catch(Exception e)
	{
		System.out.println("ERROR");
		}
	}
}

/* Note: Identify the error, rectify it and get the output. */

