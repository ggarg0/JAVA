package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
	public static void main(String args[]) {
		Interval[] arr = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6), new Interval(5, 7),
				new Interval(7, 8) };
	//	Interval[] arr1 = { new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18) };
		
		Arrays.sort(arr, (a,b) -> Integer.compare(a.getX(), b.getX()));
		System.out.println(Arrays.toString(arr));
		
		
		List<Interval> input = Arrays.asList(arr);
		List<Interval> output = new ArrayList<Interval>();
		int outputCounter = 0;

		output.add(new Interval(input.get(outputCounter).getX(), input.get(outputCounter).getY()));

		if (input == null || input.size() == 0) {
			System.out.println("Invalid intervals");
		} else {
			for (int i = 1; i < input.size(); i++) {
				if (output.get(outputCounter).getY() >= input.get(i).getX()) {
					output.get(outputCounter)
							.setY(input.get(i).getY() > output.get(outputCounter).getY() ? input.get(i).getY()
									: output.get(outputCounter).getY());
				} else {
					output.add(new Interval(input.get(i).getX(), input.get(i).getY()));
					outputCounter++;
				}
			}
			System.out.println(output);
		}
	}
}

class Interval {
	private int x;
	private int y;

	@Override
	public String toString() {
		return "Interval [x=" + x + ", y=" + y + "]";
	}

	public Interval(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}