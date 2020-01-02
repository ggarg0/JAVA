import java.util.*;

class ThreadWait{
	public static void main(String[] a){
		ThreadB b=new ThreadB();
		for (int i=0; i<10; i++){
			b.display();
		}
	}
}
class ThreadB{
	static int total;
	public synchronized void display(){
		try	{
			total = total + 10;
			Thread.sleep(2000);
			System.out.println("B complete call from display method -> Total : " + total + new Date());
		}
		catch(Exception e){
			System.out.println("InterruptedException"+e);
		}
	}
}