public class MyStack {
	
	private int maxSize;
	private Object[] data;
	private int index = -1;

	public MyStack(int size) {
		maxSize = size;
		data = new Object[maxSize];
	}

	public void resizeStack() {
		maxSize = maxSize * 2;
		Object[] temp = new Object[maxSize];

		for (int i = 0; i <= index; i++)
			temp[i] = data[i];
		
		this.data = temp;
	}

	public void push(Object obj) {
		if (isFull())
			resizeStack();

		data[++index] = obj;
		printStack();
	}

	public void pop() {		
		if (isEmpty())
			System.out.println("Stack is empty");
		else {
			data[index] = null;
			index--;
			printStack();
		}		
	}

	public Object peek() {
		return data[index];
	}

	public boolean isEmpty() {
		return (index == -1);
	}

	public boolean isFull() {
		return (index == maxSize - 1);
	}

	public void printStack() {
		for (int i = 0; i <= maxSize - 1; i++) {
			Object value = data[i];
			System.out.print(value + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyStack theStack = new MyStack(5);
		theStack.pop();
		theStack.push(1);
		theStack.push(2);
		theStack.push(3);
		theStack.push(4);
		theStack.push(5);
		theStack.push(6);
		theStack.pop();
		theStack.pop();
		System.out.println("Peek : " + theStack.peek());
	}
}