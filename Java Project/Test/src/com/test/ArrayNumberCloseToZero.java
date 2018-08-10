package com.test;

import java.util.Arrays;

public class ArrayNumberCloseToZero {

	public static void main(String[] a) {

		int[] array = { 0, 7, -2, 1, 12 };
		Arrays.sort(array);
		int num = array[0];
		int absNum = Math.abs(num);
		
		if (absNum != 0) {
			for (int i = 1; i < array.length; i++) {
				int newAbs = Math.abs(array[i]);
				if (newAbs == 0) {
					num = array[i];
					break;
				} else if (newAbs < absNum) {
					absNum = newAbs;
					num = array[i];
				}
			}
		}
		System.out.println("Number : " + num);
	}
}
