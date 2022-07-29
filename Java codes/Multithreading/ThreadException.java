package com.multithreading;

class ThreadException extends Thread{

	int total = 50;
	public void run() {
	try {
			System.out.println(Thread.currentThread().getName() + " -> " + System.currentTimeMillis());
		    throw new RuntimeException("game over");
	    } catch (RuntimeException e) {

			 Thread t = Thread.currentThread();
             t.getUncaughtExceptionHandler().uncaughtException(t, e);

	     	 //System.out.println(e);
	     }
	}
	public static void main(String[] a)	{
		ThreadException b=new ThreadException();
		try{
			b.start();
		}
		catch(Exception e){
			System.out.println("Exception : " + e);
		}
	}
}