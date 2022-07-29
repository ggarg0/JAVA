public class WaitThread implements Runnable{

	@Override
	public void run() {
		NotificationTest test = NotificationTest.getNotificationTest();
		try {
			test.shouldGo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + " finished Execution");
	}

}
