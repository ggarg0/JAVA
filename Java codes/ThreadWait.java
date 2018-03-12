class ThreadWait{
	public static void main(String[] a){
		ThreadB b=new ThreadB();
		ThreadB b1=new ThreadB();
		b.start();
		b.display();
		//b1.start();
	//	b1.display();
	}
}
class ThreadB extends Thread{
	static int total;
	public void run(){
		synchronized(this){
			for (int i=0; i<10; i++)
				total+=i;
			System.out.println("Call notify from run method after calculating total");
			notify();
		}
	}
	public synchronized void display(){
		try	{
			System.out.println("Waiting for B to complete from display method - " + Thread.currentThread().getName() + " -> Total : "+ total);
			wait();
			System.out.println("B complete call from display method -> Total : " + total);
		}
		catch(Exception e){
			System.out.println("InterruptedException"+e);
		}
	}
}