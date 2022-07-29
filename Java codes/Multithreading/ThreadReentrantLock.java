package Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLock extends Thread {
	private final ReentrantLock lock = new ReentrantLock();
	private static int i = 0;

	public void show(String name) {

		boolean ans = lock.tryLock();
		if (ans) {
			try {
				i++;			
				lock.lock();
				System.out.println("Count : " + i + " - thread : " + name + " and hold " + lock.getHoldCount());
				lock.unlock();
			} finally {
				lock.unlock();
			}
		}
	}

	public void run() {
		while (i < 10) {
			show(Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final ThreadReentrantLock lockExample = new ThreadReentrantLock();
		Thread t1 = new Thread(lockExample, "ThreadOne");
		Thread t2 = new Thread(lockExample, "ThreadTwo");
		t1.start();
		t2.start();
	}
}
