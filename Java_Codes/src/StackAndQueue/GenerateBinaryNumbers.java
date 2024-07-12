package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//For number = 3 , result = {"1","10","11"};
public class GenerateBinaryNumbers {

	public static String[] findBinaryNumbers(int number) {
		String[] result = new String[number];
		Queue<String> queue = new ArrayDeque<String>();

		queue.add("1");
		System.out.println(((ArrayDeque<String>) queue).size());
		for (int i = 0; i < number; i++) {
			result[i] = queue.remove();
			String s1 = result[i] + "0";
			String s2 = result[i] + "1";
			queue.add(s1);
			queue.add(s2);
		}
		//System.out.println(queue.toString());
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findBinaryNumbers(8)));
	}
}
