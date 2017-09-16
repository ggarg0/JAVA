

class DeadLockDemoThread extends Thread{
DeadLockDemo obj = DeadLockDemo.getDeadLockDemo();

public void run(){
	System.out.print("Ss");
   try{
	   System.out.println("In run");
	   obj.method1();
    Thread.sleep(500);
    obj.method2();
      System.out.println(Thread.currentThread().getName());
   }catch(Exception e){System.out.println(e);}
 }

public static void main(String args[]){
 DeadLockDemoThread test=new DeadLockDemoThread();
 Thread[] threads = new Thread[7];
 try{
 for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread("Thread : "+i);

      threads[i].start();
	}
}catch(Exception e){System.out.println(e);}
 }
}