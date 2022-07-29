public class DeadLockThread {
	public Object Lock1 = new Object();
	public Object Lock2 = new Object();

	public static void main(String args[]) {
		new DeadLockThread().process();
	}

	public void process() {
		try {
			Thread t1 = new ThreadDemo1(Lock1, Lock2);
			Thread t2 = new ThreadDemo2(Lock1, Lock2);

			t1.start();
			t1.join();
			t2.start();
			
		} catch (InterruptedException e) {
		}
	}
}

class ThreadDemo1 extends Thread {
	Object Lock1;
	Object Lock2;

	public ThreadDemo1(Object Lock1, Object Lock2) {
		this.Lock1 = Lock1;
		this.Lock2 = Lock2;
	}

	public void run() {
		try {
			synchronized (Lock1) {
				System.out.println("Thread 1: Holding lock 1...");
				Thread.sleep(10);
				System.out.println("Thread 1: Waiting for lock 2...");
				synchronized (Lock2) {
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		} catch (InterruptedException e) {
		}
	}
}

class ThreadDemo2 extends Thread {
	Object Lock1;
	Object Lock2;

	public ThreadDemo2(Object Lock1, Object Lock2) {
		this.Lock1 = Lock1;
		this.Lock2 = Lock2;
	}

	public void run() {
		try {
			// Thread.sleep(100);
			synchronized (Lock2) {
				System.out.println("Thread 2: Holding lock 2...");
				Thread.sleep(100);
				System.out.println("Thread 2: Waiting for lock 1...");
				synchronized (Lock1) {
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		} catch (InterruptedException e) {
		}
	}
}
