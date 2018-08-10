public class MyQueue {

	private int maxSize;
	private Object[] data;
	private int index = -1;

	public MyQueue(int size) {
		maxSize = size;
		data = new Object[maxSize];
	}
	
	public void resizeQueue() {
		int newSize = maxSize * 2;
		Object[] temp = new Object[newSize];

		for (int i = 0; i <= index; i++)
			temp[i] = data[i];

		this.maxSize = newSize;
		this.data = temp;
	}
	
	public void enqueue(Object obj) {
		if (isFull()) 
			resizeQueue();
		
		data[++index] = obj;
		printQueue();				
	}

	public void dequeue(){
		if (isEmpty()) {
			System.out.println("Queue is empty");
		}else {			
			for (int i = 0; i <= index - 1; i++) {
				data[i] = data[i + 1];
			}
			data[index] = null;
			index--;
			printQueue();
		}		
	}

	public boolean isEmpty() {
		return (index == -1);
	}

	public boolean isFull() {
		return (index == maxSize-1);
	}

	public void printQueue() {
		for (int i = 0; i <= maxSize - 1; i++) {
			Object value = data[i];
			System.out.print(value + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		queue.dequeue();
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		queue.enqueue("5");
		queue.enqueue("6");
		queue.enqueue("7");
		queue.dequeue();
		queue.dequeue();
	}
}