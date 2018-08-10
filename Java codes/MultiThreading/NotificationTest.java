
public class NotificationTest {

	private volatile boolean go = false;
	static NotificationTest test = new NotificationTest();
	public static void main(String args[])  {
		
		NotifyThread NT = new NotifyThread();
		WaitThread WT = new WaitThread();
		
		Thread t1 = new Thread(WT, "WT1"); //will wait
		Thread t2 = new Thread(WT, "WT2"); //will wait
		Thread t3 = new Thread(WT, "WT3"); //will wait
		Thread t4 = new Thread(NT,"NT1"); //will notify
		Thread t5 = new Thread(NT,"NT2"); //will notify
		Thread t6 = new Thread(NT,"NT3"); //will notify

		try {
			//starting all waiting thread
			t1.start();
			t2.start();
			t3.start();
			
			//pause to ensure all waiting thread started successfully
			Thread.sleep(2000);
			t4.start();
			Thread.sleep(2000);
			t5.start();
			Thread.sleep(2000);
			t6.start();
			
		} catch (InterruptedException e) {
				e.printStackTrace();
		}		
	}

	public static NotificationTest getNotificationTest()
	{
		
		return test;
	}

	public synchronized void shouldGo() throws InterruptedException {
		while(go != true){
			System.out.println(Thread.currentThread()+ " is going to wait on this object");
			wait(); //release lock and reacquires on wakeup
			System.out.println(Thread.currentThread() + " is woken up");
		}
		go = false;//resetting condition
	}
	/*
	 * both shouldGo() and go() are locked on current object referenced by "this" keyword
	 */
	public synchronized void go() {
		while (go == false){
			System.out.println(Thread.currentThread()+ " is going to notify all or one thread waiting on this object");
			go = true; //making condition true for waiting thread
		//	notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
			notifyAll(); // all waiting thread WT1, WT2,WT3 will woke up
		}

	}

}
