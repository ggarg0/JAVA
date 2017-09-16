
/*
execute the program , then modify the program by removing the comment in
line2, then comment the line1
*/


class TryandFinally {
	public static void main(String [] args) {
		try {
			int i=10/0;           //line 1
			//int i=10/2;		 //line 2
		}
		finally {
			System.out.println("This is finally.");
		}
    }
}