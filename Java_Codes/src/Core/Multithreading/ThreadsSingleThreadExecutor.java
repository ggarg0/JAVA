package Core.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadsSingleThreadExecutor extends Thread {
    public static void main(String a[]) {
        System.out.println("Main thread start");
        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service1 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 8; i++) {
            service.execute(new ThreadsSingleThreadExecutor());
        }
        System.out.println("Main thread running");
        service.shutdown();
        service1.shutdown();
        System.out.println("Main thread stopped");
    }

    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Inside run method");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
