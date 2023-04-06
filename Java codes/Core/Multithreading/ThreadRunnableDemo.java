package Core.Multithreading;

class runnableExtThreads implements Runnable {
	runnableExtThreads() {
		System.out.println("Base Constructor");
	}

	public void run() {
		// int i=1/0;
		// System.exit(0);
		System.out.println("run Constructor");
	}
}

class ThreadRunnableDemo {
	public static void main(String a[]) {
		System.out.println("Hi i am main thread");
		runnableExtThreads obj = new runnableExtThreads();
		Thread t = new Thread(obj);
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("flag : " + flag);
				t.sleep(500);
				flag = false;
			}

			t.start();
			// t.sleep(1000);
			System.out.println("flag : " + flag);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			System.out.println("This is finally.");
		}
	}
}
