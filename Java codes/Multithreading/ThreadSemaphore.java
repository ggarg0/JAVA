package Multithreading;

import java.util.concurrent.Semaphore;

public class ThreadSemaphore implements Runnable {
	Semaphore binary = new Semaphore(2);

	public static void main(String args[]) {
		ThreadSemaphore test = new ThreadSemaphore();
		Thread[] threads = new Thread[5];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(test);
			threads[i].start();
		}
	}

	public void run() {
		try {
			binary.acquire();
			System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
		}
	}

}