package Collections;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		// add values
		pq.add(1);
		pq.add(50);
		pq.add(33);
		pq.add(42);
		pq.add(62);
		pq.add(21);
		
		System.out.println("All values : " + pq);
		System.out.println("Head of queue : " + pq.peek());
		System.out.println("All values after peek : " + pq);

		System.out.println("Head of queue: " + pq.poll());
		System.out.println("All values after poll : " + pq);

		System.out.println("Head of queue: " + pq.element());
		System.out.println("All values after element : " + pq);

		System.out.println("Head of queue: " + pq.remove());
		System.out.println("All values after remove : " + pq);
	}
}
