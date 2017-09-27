class runnableExtThreads extends  Thread
{
	runnableExtThreads()
	{
		System.out.println("Base Constructor");
	}
	public void run()
		{
			System.out.println("Base Thread");
	}


}

class ExtrunnableDemo
{
	public static void main(String a[])
	{
		System.out.println("Hi i am main thread");

		Thread t=new Thread();
		t.start();
		t.start();
		System.out.println("Main thread running");
	}
}
