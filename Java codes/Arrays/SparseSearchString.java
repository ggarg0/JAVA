package Arrays;

public class SparseSearchString {

	public static int searchForString(String[] arr, String target) {
		int result = -1;
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (start < end) {
			boolean flag = true;
			mid = (start + end) / 2;
			if (arr[mid].isEmpty()) {
				int i = mid;
				int j = mid;
				while (flag) {
					if (++i <= end && !arr[i].isEmpty()) {
						mid = i;
						flag = false;
					} else if (--j >= start && !arr[j].isEmpty()) {
						mid = j;
						flag = false;
					}

					if (i > end && j < start) {
						return -1;
					}
				}
			}

			if (arr[mid].equals(target)) {
				return mid;
			} else if (arr[mid].compareTo(target) > 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] array = { "", "educative", "", "", "", "hello", "", "learning", "world", "", "", "" };
		System.out.println("educative found : " + searchForString(array, "educative"));
		System.out.println("learning found : " + searchForString(array, "world"));
	}
}
