package Core.Multithreading;

class ThreadWaitDemo extends Thread {
	private int total;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++)
				total += i;
			System.out.println("Call notify from run method after calculating total");
			this.notify();
		}
	}

	public synchronized void display() {
		try {
			System.out.println("Waiting for B to complete from display method - " + Thread.currentThread().getName()
					+ " -> Total : " + total);
			this.wait();
			System.out.println("B complete call from display method -> Total : " + total);
		} catch (Exception e) {
			System.out.println("InterruptedException" + e);
		}
	}

	public static void main(String[] a) {
		ThreadWaitDemo b = new ThreadWaitDemo();
		b.start();
		b.display();
	}
}