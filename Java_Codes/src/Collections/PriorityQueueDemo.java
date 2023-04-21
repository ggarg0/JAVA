package Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
	public static void main(String[] args) {

		Queue<String> pq = new PriorityQueue<String>();
		pq.add("Ross");
        pq.add("John");      
        pq.add("Frank");
        pq.add("Adam");
        
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
