class ThreadA
{

	public static void main(String[] a)
	{
		ThreadB b=new ThreadB();
		b.start();
		b.display();

	}


}
class ThreadB extends Thread
{
	int total;
	public void run()
	{
		synchronized(this)
		{
			for (int i=0;i<10;i++)
			{
				total+=i;
				System.out.println("total"+total);
			}
			System.out.println("Call notify");
			notify();
		}
	}
	public synchronized void display()
	{
		try
		{
			System.out.println("Waiting for B to complete");
			wait();
			System.out.println("B complete");
		}
		catch(Exception e)
		{
			System.out.println("InterruptedException"+e);
		}
	}
}