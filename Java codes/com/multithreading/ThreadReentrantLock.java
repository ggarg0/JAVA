package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLock extends Thread {
	private final Lock lock = new ReentrantLock();
	private static int i = 0;

	public void show(String name) {
		lock.lock();
		try {
			i++;

			System.out.println("Count : "+ i + " - thread : " + name);
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		while (i < 6) {
			show(Thread.currentThread().getName());
			try {
				Thread.sleep(10);
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
