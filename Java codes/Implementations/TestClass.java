package Implementations;

//import for Scanner and other utility classes
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TestClass {
	public static void main(String args[]) throws Exception {
		
		Scanner s1 = new Scanner(System.in);
		String types = s1.nextLine();
		String[] typeStrArr = types.split(" ");

		List<Integer> typesList = new ArrayList<Integer>();
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
		s1.close();
	}
}