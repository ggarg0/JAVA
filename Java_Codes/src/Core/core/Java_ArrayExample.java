package Core.core;

import java.util.Arrays;
import java.util.Scanner;

public class Java_ArrayExample {

	public static void main(String[] args) {
		int i;
		
		Scanner sc = new Scanner(System.in);
		// declaring and initializing an array
		char arr[] = { 1, 2, 3, 6, 9 };
		
		// defining another array arr1
		int arr1[] = new int[5];
		// reading values from the user
		System.out.println("Enter the numbers (size = 5) :");
		
		for (i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		
		System.out.println("Previous array with initialized size is: ");
		for (i = 0; i < arr1.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\nThe new array we have entered is:");
		for (i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		char[] arrNew = {'g','h','w','v','s'};
		System.out.println("Char array : ");
		System.out.println(Arrays.toString(arrNew));
	}
}
