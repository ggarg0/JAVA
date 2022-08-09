
/* IMPORTANT: Multiple classes and nested static classes are supported */
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class TestClass {
	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT //Scanner Scanner s = new Scanner(System.in); String name =
		 * s.nextLine(); // Reading input from STDIN System.out.println("Hi, " + name +
		 * "."); // Writing output to STDOUT
		 */
		// Write your code here
		Scanner s1 = new Scanner(System.in);
		String n = s1.nextLine();
		String types = s1.nextLine();
		String[] typeStrArr = types.split(" ");
		// Facing issues with generics in this editor
		List typesList = new ArrayList();
		for (int i = 0; i < typeStrArr.length; i++) {
			typesList.add(Integer.parseInt(typeStrArr[i]));
		}
		Collections.sort(typesList);
		int leastElement = Integer.parseInt(typesList.get(0).toString());
		int maximumNo = 0;
		for (int i = leastElement; i >= 1; i--) {
			boolean isDivided = true;
			for (Object obj : typesList) {
				int t = Integer.parseInt(obj.toString());
				if (t % i == 0) {
				} else {
					isDivided = false;
				}
			}
			if (isDivided) {
				maximumNo = i;
				break;
			}
		}
		System.out.println(maximumNo);
	}
}