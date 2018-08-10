import java.util.*;
import java.util.concurrent.*;

public class ThreadCallable implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(100);
        return Thread.currentThread().getName();
    }
    public static void main(String args[]){
        ExecutorService executor = Executors.newFixedThreadPool(6);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new ThreadCallable();
        for(int i=0; i< 5; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                System.out.println(new Date()+ " :: "+fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}