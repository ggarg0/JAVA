package Implementations.customthreadpool;

public class ExecutorServiceCustom {
    public static void main(String[] args) {
        MyExecutorService service = MyExecutors.myNewFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            service.submit(new Mytask());
        }
    }
}
