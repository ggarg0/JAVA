package Core.exceptionhandling;

class TryandFinally {
	public static void main(String[] args) {
		try {
			int i = 10 / 0; 
			// int i=10/2; 
			System.out.println(i);
		} finally {
			System.out.println("This is finally.");
		}
	}
}