package Core;

import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		  String testIsBlank = "";
		  System.out.println(testIsBlank.isBlank());   // prints true
		  
		  String testLines = "Hello !! \n Java \n 11";
		  System.out.println(testLines.lines().collect(Collectors.toList()));   // prints [Hello !! ,  Java ,  11]

		  String testRepeat = "Java 11 ";
		  System.out.println(testRepeat.repeat(3)); // prints Java 11 Java 11 Java 11
		  
		  String testStrip = " Java 11 ";
		  System.out.println(testStrip.strip()); // prints Java 11
	}
}