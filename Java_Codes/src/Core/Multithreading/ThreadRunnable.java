package Core.Multithreading;

import java.util.Date;

class MyRunnableImplementation implements Runnable {

	private static int counter = 0;
    public void run() {
        try {
			counter++;
            System.out.println(counter + ") Starting => " +
                    Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(
                    Thread.currentThread().getName() + "\twith Runnable: MyRunnableImplementation runs...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        System.out.println("Executing program...");
        MyRunnableImplementation test = new MyRunnableImplementation();
        Thread[] threads = new Thread[9];
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(test, "Thread-" + i);
                threads[i].start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("Finishing program...");
    }
}