package Core.Multithreading;

class ThreadJoinMethod implements Runnable {

	public void run() {
		try {
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + " and isAlive : " + Thread.currentThread().isAlive());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ThreadJoinMethod test = new ThreadJoinMethod();
		Thread[] threads = new Thread[5];
		try {
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(test, "Thread - " + i);
				threads[i].start();
				threads[i].join();
				System.out.println(threads[i].getName() + " and isAlive : " + threads[i].isAlive());
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
			System.out.println(e.getMessage());
		}
	}
}
