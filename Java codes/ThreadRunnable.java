
class MyRunnableImplementation implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
    	     System.out.println(Thread.currentThread().getName() + "\twith Runnable: MyRunnableImplementation runs..." + i);
        }
    }
}
public class ThreadRunnable {
    public static void main(String[] args) {
        System.out.println("Executing program...");
        MyRunnableImplementation r = new MyRunnableImplementation();
        Thread thread1 = new Thread(r, "Thread 1");
        thread1.start();
     }
}