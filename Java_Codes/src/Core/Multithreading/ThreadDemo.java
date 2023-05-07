package Core.Multithreading;

class ThreadDemo extends Thread {
    // run() method contains the code that is executed by the thread.
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

    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating thread...");
        ThreadDemo thread = new ThreadDemo();
        ThreadDemo thread1 = new ThreadDemo();
		thread.setName("Thread-0");
		thread.setPriority(5);

		thread1.setName("Thread-1");
		thread1.setPriority(10);

        System.out.println("Starting thread...");
        thread.start();
        thread1.start();
    }
}
