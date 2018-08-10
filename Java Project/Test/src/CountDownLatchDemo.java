import java.util.Date;
import java.util.concurrent.*;

public class CountDownLatchDemo {
    public static void main(String args[]) {
       final CountDownLatch latch = new CountDownLatch(3);
       new Thread(new Service1("CacheService", 1000, latch)).start();
       new Thread(new Service1("AlertService", 10000, latch)).start();
       new Thread(new Service1("ValidationService", 1000, latch)).start();

       try{
            latch.await();  //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now");
       }catch(InterruptedException ie){
           ie.printStackTrace();
       }
    }
}

class Service1 implements Runnable{
    private String name;
    private int timeToStart;
    private CountDownLatch latch;

    public Service1(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            System.out.println("EX : " + ex);;
        }
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
}