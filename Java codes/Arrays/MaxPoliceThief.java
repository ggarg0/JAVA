package Arrays;

import java.util.ArrayList;

public class MaxPoliceThief {

	public static int policeThief(char[] arr, int k) {
		int result = 0;
		ArrayList<Integer> thieves = new ArrayList<Integer>();
		ArrayList<Integer> police = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'T') {
				thieves.add(i);
			} else {
				police.add(i);
			}
		}

		int thiefCount = 0, policeCount = 0;
		while (thiefCount < thieves.size() && policeCount < police.size()) {
			if (thieves.get(thiefCount) - police.get(policeCount) <= k) {
				result++;
				thiefCount++;
				policeCount++;
			} else if (thieves.get(thiefCount) < police.get(policeCount)) {
				thiefCount++;
			} else {
				policeCount++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int k = 2;

		char policeTheifArray[] = { 'P', 'T', 'T', 'P', 'T' };
		System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + policeThief(policeTheifArray, k));

		char policeTheifArray1[] = { 'T', 'T', 'P', 'P', 'T', 'P' };
		System.out.println("Maximum thieves caught for {T, T, P, P, T,P}: " + policeThief(policeTheifArray1, k));
	}
}
