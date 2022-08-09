package com.test;

public class ThreadOddEven {

	private static boolean turn = false;// false is even and true is odd
	private static int count = 20;

	public static void main(String[] args) {

		Object o = new Object();
		new Thread(new EvenThread(o)).start();
		new Thread(new OddThread(o)).start();
	}

	static class EvenThread implements Runnable {
		Object o;

		public EvenThread(Object o) {
			this.o = o;
		}

		@Override
		public void run() {
			synchronized (o) {
				for (int i = 0; i <= count; i = i + 2) {
					try {
						while (turn) {
							o.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("Even : " + i);
						turn = !turn;
						o.notifyAll();
					}
				}
			}
		}
	}

	static class OddThread implements Runnable {

		Object o;

		public OddThread(Object o) {
			this.o = o;
		}

		@Override
		public void run() {
			synchronized (o) {
				for (int i = 1; i <= count; i = i + 2) {
					try {
						while (!turn) {
							o.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("Odd : " + i);
						turn = !turn;
						o.notifyAll();
					}
				}
			}
		}
	}
}