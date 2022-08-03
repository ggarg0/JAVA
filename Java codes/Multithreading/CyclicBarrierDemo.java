package Multithreading;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	private static int sum = 10;

	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(4);
		Party first = new Party(1000, barrier, "PARTY-1", sum);
		Party second = new Party(2000, barrier, "PARTY-2", sum);
		Party third = new Party(3000, barrier, "PARTY-3", sum);
		Party fourth = new Party(4000, barrier, "PARTY-4", sum);
		first.start();
		second.start();
		third.start();
		fourth.start();
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;
	private int sum;
	
	public Party(int duration, CyclicBarrier barrier, String name, int sum) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
		this.sum = this.sum + sum; 
	}

	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has started running again");
			System.out.println("Sum: " + sum);
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
