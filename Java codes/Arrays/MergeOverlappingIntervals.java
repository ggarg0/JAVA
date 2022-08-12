package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {
	public static void main(String args[]) {
		Interval[] arr = { new Interval(1, 3), new Interval(2, 4),  new Interval(6, 8) };
		//Interval[] result = new Interval[arr.length];
		
		List<Interval> output = new ArrayList<Interval>();
		
		for (int i = 1; i <= arr.length; i++) {
			if(arr[i-1].getSecond() > arr[i].getFirst()) {
				output.add(new Interval(arr[i-1].getFirst(), arr[i].getSecond()));
				//i++;
			} else {
				output.add(new Interval(arr[i-1].getFirst(), arr[i-1].getSecond()));
			}
		}
		System.out.println(output);
	}
}

class Interval {
	@Override
	public String toString() {
		return "Interval [first=" + first + ", second=" + second + "]";
	}

	private int first;
	private int second;

	public Interval(int x, int y) {
		this.first = x;
		this.second = y;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
}
