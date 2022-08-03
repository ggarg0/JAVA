package Multithreading;

class ThreadA{
	public static void main(String[] a)	{
		ThreadB b=new ThreadB();
		b.start();
		b.display();
	}
}
class ThreadB extends Thread{
	int total;
	public void run()	{
		synchronized(this)		{
			for (int i=0;i<10;i++){
				total+=i;

			}
			System.out.println("Call notify : " + Thread.holdsLock(this));
			notify();
			System.out.println("End notify : " + Thread.holdsLock(this));
		}
	}
	public synchronized void display()	{
		try{
			System.out.println("Waiting for B to complete : " + Thread.holdsLock(this));
			wait();
			System.out.println("B complete");
			System.out.println("total : "+total);
		}
		catch(Exception e){
			System.out.println("InterruptedException"+e);
		}
	}
}