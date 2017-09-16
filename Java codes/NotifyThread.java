
public class NotifyThread implements Runnable{

	@Override
	public void run() {
		NotificationTest test = NotificationTest.getNotificationTest();
		test.go();
		System.out.println(Thread.currentThread() + " finished Execution");
	}
	
}
