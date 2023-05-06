package Core.Multithreading;

public class RunnableDemo implements Runnable {

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");
        RunnableDemo runnable = new RunnableDemo();

        System.out.println("Creating Thread...");
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        System.out.println("Starting Thread...");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("Moving Inside : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Moving Outside : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}