package com.test.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<Message> queue;
	public Producer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			Message msg = null;
			for (int i = 0; i < 20; i++) {
				msg = new Message("" + i);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			}
			msg = new Message("exit");
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
