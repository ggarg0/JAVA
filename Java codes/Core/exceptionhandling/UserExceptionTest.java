package Core.exceptionhandling;

 class InvalidAmount extends Exception{
	public InvalidAmount(){
		super("Inavlid Amount");
	}
	public InvalidAmount(String msg){
			super(msg);
	}
}

public class UserExceptionTest{
	public static void main(String arg[]){
			int amount=-1;
			try{
				if(amount<0)	{
					throw new InvalidAmount("this is not a valid amount");
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
}

/* Note: Analyze the code and understand the output. */