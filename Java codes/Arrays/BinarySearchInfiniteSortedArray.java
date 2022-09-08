package Arrays;

class ArrayReader {
	int[] arr;

	ArrayReader(int[] arr) {
		this.arr = arr;
	}

	public int get(int index) {
		if (index >= arr.length)
			return Integer.MAX_VALUE;
		return arr[index];
	}
}

public class BinarySearchInfiniteSortedArray {

	public static int search(ArrayReader reader, int key) {
		int start = 0, mid = 0, end = 1;
		int searchSize = (end - start) * 2;
			
		while (reader.get(end) <= key) {			
			start = end + 1;
			searchSize = searchSize * 2;
			end = end + searchSize;
		}

		System.out.println(reader.get(start) + " and " + reader.get(end));
		while (start < end) {
			mid = (start + end)/2;
			
			if(reader.get(mid) > key) {
				end = mid;
			} else if(reader.get(mid) < key) {
				start = mid + 1;
			} else {
				return mid;
			}
		}		
		return -1;
	}

	public static void main(String[] args) {
		ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
		System.out.println(search(reader, 16));
		System.out.println(search(reader, 11));
		reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
		System.out.println(search(reader, 15));
		System.out.println(search(reader, 200));

	}

}
