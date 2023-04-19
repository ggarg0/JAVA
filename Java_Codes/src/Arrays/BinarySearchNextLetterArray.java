package Arrays;

public class BinarySearchNextLetterArray {

	public static char searchNextLetter(char[] letters, char key) {

		if (letters[letters.length - 1] < key) {
			return letters[0];
		}

		int start = 0, end = letters.length - 1, mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;

			if (letters[mid] == key) {
				return letters[mid];
			} else if (letters[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return letters[start];
	}

	public static void main(String[] args) {
		System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
		System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'g'));

	}

}
