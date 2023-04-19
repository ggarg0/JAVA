package Core.Multithreading;

class ThreadJoinMethod implements Runnable {

	public void run() {
		try {
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		ThreadJoinMethod test = new ThreadJoinMethod();
		Thread[] threads = new Thread[9];
		try {
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(test, "Thread" + i);
				threads[i].start();
				threads[i].join();
			}

			Thread t1 = new Thread(test, "IMP");
			Thread t2 = new Thread(test, "FIRST");
			Thread t3 = new Thread(test, "SECOND");

			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
