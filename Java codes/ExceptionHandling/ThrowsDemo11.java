package ExceptionHandling;

class NumberTest1 {
	private int num;
	public void accept(int n)  throws Exception{
		if( n == 0 ){
			throw new Exception("Can't assign zero...");
		}
	}
}
public class ThrowsDemo11 {
	public static void main(String args[]) throws Exception{
		try{
			NumberTest1 ob = new NumberTest1();
			ob.accept(0);
			System.out.println("Gaurav");}
			catch(Exception e)
		{
			System.out.println("Gaurav Exp");
		}
	}
}
