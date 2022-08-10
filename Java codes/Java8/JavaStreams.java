package Java8;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class JavaStreams {
	public static void main(String args[]) {

		List<Integer> listOfIntegers = Arrays.asList(1, 2, 1, 4, 56, 7, 89, 10);
			
		System.out.println("Sum: " + listOfIntegers.stream().mapToInt(v -> v).sum());
		System.out.println("Min: " + listOfIntegers.stream().mapToInt(v -> v).min());
		System.out.println("max: " + listOfIntegers.stream().mapToInt(v -> v).max());
		System.out.println("avg: " + listOfIntegers.stream().mapToInt(v -> v).average());

		String[] programming = { "Java", "C++", "Perl", "C" };

		List<String> list = Arrays.asList(programming);
		List<String> programmingListLowerCase = list.stream().map(String::toUpperCase)
														.collect(toList());

		System.out.println("Does programming Array contains Java? " + 
								programmingListLowerCase.contains("JAVA"));
		System.out.println("Does programming Array contains Java? " + 
								programmingListLowerCase.contains("java"));
		System.out.println("Index of Java in programming Array is : " + 
								programmingListLowerCase.indexOf("java"));

		// filter function
		Stream<String> stream = list.stream().filter(p -> p.length() > 3);
		String[] arr = stream.toArray(String[]::new);

		System.out.println(Arrays.toString(arr));
	}
}