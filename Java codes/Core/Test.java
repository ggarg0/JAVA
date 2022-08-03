public class Test {
	public String longestCommonPrefix(String[] strs) {
		String compare = strs[0];
		boolean match = false;
		
		while (compare.length() > 0) {
			for (String str : strs) {
				if (str.contains(compare)) {
					compare = compare.substring(0, compare.length() - 1);
					
				} else {
					
				}
				continue;
			}
			return compare;
		}

		return "";
	}

	public static void main(String arg[]) {

		String[] strs = { "flower", "flow", "flight" };
		System.out.println(new Test().longestCommonPrefix(strs));

	}
}
