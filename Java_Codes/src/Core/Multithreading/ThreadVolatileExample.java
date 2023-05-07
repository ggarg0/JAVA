package Core.Multithreading;

class ExampleThread extends Thread {
    private volatile int count;
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " : " + count);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

        }
    }
}

public class ThreadVolatileExample {
    public static void main(String args[]) {
        new ExampleThread().start();
        new ExampleThread().start();
    }
}