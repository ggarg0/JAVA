package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOverlappingIntervals {
	public static void main(String args[]) {
		Intervals[] arr = { new Intervals(4, 5), new Intervals(2, 3), new Intervals(3, 6), new Intervals(5, 7),
				new Intervals(7, 8) };
		Arrays.sort(arr, (a, b) -> Integer.compare(a.getx(), b.getx()));
		
		System.out.println(Arrays.toString(arr));
		List<Intervals> list = new ArrayList<Intervals>();

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].gety() > arr[i + 1].getx()) {

				if (!list.contains(arr[i]))
					list.add(arr[i]);

				if (!list.contains(arr[i + 1]))
					list.add(arr[i + 1]);
			}
		}
		System.out.println(list.toString());
	}
}

class Intervals {

	private int x;
	private int y;

	@Override
	public String toString() {
		return "Intervals [x=" + x + ", y=" + y + "]";
	}

	public Intervals(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public void setx(int x) {
		this.x = x;
	}

	public void sety(int y) {
		this.y = y;
	}
}