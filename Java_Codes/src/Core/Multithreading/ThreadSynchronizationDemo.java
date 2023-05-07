package Core.Multithreading;

class Account {
	private int balance = 50;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}
}

public class ThreadSynchronizationDemo implements Runnable {
	private Account acct = new Account();

	public static void main(String[] a) {
		ThreadSynchronizationDemo r = new ThreadSynchronizationDemo();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("John");
		two.setName("Tim");
		one.start();
		two.start();
	}

	public void run() {
		for (int x = 0; x < 4; x++) {
			makeWithDrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("Account is overdrawn");
			}
		}
	}

	private synchronized void makeWithDrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(
					Thread.currentThread().getName() + " is going to withdraw. Current balance : " + acct.getBalance());
			try {
				acct.withdraw(amt);
				//Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " completes the withdrawal. Current balance : "
						+ acct.getBalance());
			} catch (Exception e) {
				System.out.println("InterruptedException" + e);
			}

		} else {
			System.out.println("Not Enough in account for " + Thread.currentThread().getName() + " to withdraw "
					+ acct.getBalance());
		}
	}
}