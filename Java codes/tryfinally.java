import java.util.regex.Pattern;

class tryfinally{
	public int divide(int a) throws Exception{
	int b=0;
	try{
		b = 10/a;
		return b;
	}
	finally{
		System.out.println("Finally");
		return 3;
	}
}
public static void main(String[] a){
	try{
		tryfinally obj = new tryfinally();
		int result = obj.divide(0);
		System.out.println("result Main : " + result);
	}catch(Exception e)	{
		System.out.println("Divide by Zero 1..... ");
	}
}
}