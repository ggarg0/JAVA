import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadsSingleThreadExecutor extends  Thread{
	public static void main(String a[])	{
		System.out.println("Main thread start");
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i =0; i<3; i++){
		    service.execute(new ThreadsSingleThreadExecutor());
		}
		System.out.println("Main thread running");
		service.shutdown();
	}
	public void run(){
		System.out.println("Inside run method");
	}
}
