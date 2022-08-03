package Multithreading;
import java.util.concurrent.CountDownLatch;

class Service2 implements Runnable{
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

    public Service2(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int a = 10/10;
            latch.countDown(); //reduce count of CountDownLatch by 1
            System.out.println( name + " is Up");
        } catch (Exception ex) {
            System.out.println("EX : " + ex);;
        }
        
        
    }
}
