public class CrunchifyLinkedListTest {
	public static CrunchifyLinkedList crunchifyList;
 
	public static void main(String[] args) {

		crunchifyList = new CrunchifyLinkedList();
		crunchifyList.add("1");
		crunchifyList.add("2");
		crunchifyList.add("3");
		crunchifyList.add("4");
		crunchifyList.add("7", 1);
		crunchifyList.add("4");
		System.out.println("Print list : " + crunchifyList);
		System.out.println("List size : " + crunchifyList.size());
		System.out.println("List.get(3) : " + crunchifyList.get(3));
		System.out.println("List.remove(2) : " + crunchifyList.remove(2));
		System.out.println("List.get(3) : " + crunchifyList.get(3));
		System.out.println("List.size() : " + crunchifyList.size());
		System.out.println("Print list again : " + crunchifyList);
	} 
}
 
class CrunchifyLinkedList { 
	private static int counter;
	private Node head;
 
	public CrunchifyLinkedList() {}
 
	public void add(Object data) {
 		if (head == null) {
			head = new Node(data);
		}
 
		Node crunchifyTemp = new Node(data);
		Node crunchifyCurrent = head;

		if (crunchifyCurrent != null) {
			while (crunchifyCurrent.getNext() != null) 
				crunchifyCurrent = crunchifyCurrent.getNext();
			 
			crunchifyCurrent.setNext(crunchifyTemp);
		} 
		incrementCounter();
	}
	
	public boolean remove(int index) {
		if (index < 1 || index > size())
			return false;
 
		Node crunchifyCurrent = head;
		if (crunchifyCurrent != null) {
			for (int i = 0; i < index; i++) {
				if (crunchifyCurrent.getNext() == null)
					return false;
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
			crunchifyCurrent.setNext(crunchifyCurrent.getNext().getNext());
			decrementCounter();
			return true; 
		}
		return false;
	}
 
	private static int getCounter() {
		return counter;
	}
 
	private static void incrementCounter() {
		counter++;
	}
 
	private void decrementCounter() {
		counter--;
	}
 
	public void add(Object data, int index) {
		Node crunchifyTemp = new Node(data);
		Node crunchifyCurrent = head;
 
		if (crunchifyCurrent != null) {
			for (int i = 0; i < index && crunchifyCurrent.getNext() != null; i++) {
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
		}
		crunchifyTemp.setNext(crunchifyCurrent.getNext());
		crunchifyCurrent.setNext(crunchifyTemp);
 		incrementCounter();
	}
 
	public Object get(int index){
		if (index < 0)
			return null;
		Node crunchifyCurrent = null;
		if (head != null) {
			crunchifyCurrent = head.getNext();
			for (int i = 0; i < index; i++) {
				if (crunchifyCurrent.getNext() == null)
					return null; 
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
			return crunchifyCurrent.getData();
		}
		return crunchifyCurrent; 
	}
 
	
 
	public int size() {
		return getCounter();
	}
 
	public String toString() {
		String output = ""; 
		if (head != null) {
			Node crunchifyCurrent = head.getNext();
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
			} 
		}
		return output;
	}
 
	private class Node {
		Node next;
 		Object data;
 		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}
 
		@SuppressWarnings("unused")
		public Node(Object dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}
 
		public Object getData() {
			return data;
		}
 
		@SuppressWarnings("unused")
		public void setData(Object dataValue) {
			data = dataValue;
		}
 
		public Node getNext() {
			return next;
		}
 
		public void setNext(Node nextValue) {
			next = nextValue;
		} 
	}
}