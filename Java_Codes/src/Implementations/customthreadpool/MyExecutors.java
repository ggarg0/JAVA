package Implementations.customthreadpool;

class MyExecutors {
    int capacity;

    static MyExecutorService myNewFixedThreadPool(int capacity) {
        return new MyThreadPool(capacity);
    }
}