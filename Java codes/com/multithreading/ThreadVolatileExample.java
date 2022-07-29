package com.multithreading;

class ExampleThread extends Thread {
	private volatile int testValue;
	public ExampleThread(String str){
		super(str);
	}
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				if (getName().equals("Thread 1 "))
				{
					testValue = 10;
					System.out.println( "Test Value in Thread 1 : " + testValue);
				}
				if (getName().equals("Thread 2 "))
				{
					System.out.println( "Test Value in Thread 2 : " + testValue);
				}
				Thread.sleep(500);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}
}
public class ThreadVolatileExample {
	public static void main(String args[]) {
		new ExampleThread("Thread 1 ").start();
	//	new ExampleThread("Thread 2 ").sleep(1000);
		new ExampleThread("Thread 2 ").start();
	}
}