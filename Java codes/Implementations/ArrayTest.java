import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
	public static void main(String args[]) {

		String[] programming = { "Java", "C++", "Perl", "Lisp" };
		
		List<String> programmingListLowerCase =  
				Arrays.asList(programming).stream()
							.map(String::toLowerCase).collect(toList()); 
		
		Object o =null;
		
		List<Object> list = new ArrayList();  
		list.add(o);
		System.out.println("Does programming Array contains Java? " 
									+ programmingListLowerCase.contains("JAVA"));
		System.out.println("Does programming Array contains Java? " 
									+ programmingListLowerCase.contains("java"));
		System.out.println("Index of Java in programming Array is : "
									+ programmingListLowerCase.indexOf("java"));

		list.forEach(  
		            (n)->System.out.println(n)  
		        );  
		
	}
}
