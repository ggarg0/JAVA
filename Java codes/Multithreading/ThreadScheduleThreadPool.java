package Multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable {
	private int taskId;

	public ScheduledTask(int taskId) {
		this.taskId = taskId;
	}

	public void run() {
		try {
			System.out.println("Task #" + this.taskId + " started  at " + LocalDateTime.now());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task #" + this.taskId + " stopped  at " + LocalDateTime.now());
	}
}

public class ThreadScheduleThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService sexec = Executors.newScheduledThreadPool(3);
		try {
			// Get an executor with 3 threads

			ScheduledTask task1 = new ScheduledTask(1);
			ScheduledTask task2 = new ScheduledTask(2);
			ScheduledTask task3 = new ScheduledTask(3);
			System.out.println("Start time " + LocalDateTime.now());

			// Task #1 will run after 2 seconds
			sexec.schedule(task1, 5, TimeUnit.SECONDS);

			sexec.scheduleWithFixedDelay(task2, 7, 15, TimeUnit.SECONDS);

			// Task #2 runs after 5 seconds delay and keep running every 10 seconds
			sexec.scheduleAtFixedRate(task3, 10, 20, TimeUnit.SECONDS);

			TimeUnit.SECONDS.sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sexec.shutdown();
	}
}