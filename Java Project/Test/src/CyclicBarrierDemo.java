import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(4);
		new Party(1000, barrier, "PARTY-1").start();
		new Party(2000, barrier, "PARTY-2").start();
		new Party(3000, barrier, "PARTY-3").start();
		new Party(4000, barrier, "PARTY-4").start();
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			barrier.await();
			
			System.out.println(Thread.currentThread().getName() + " has started running again");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
