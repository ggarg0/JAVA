package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	static int shortestChainLen(String start, String target, Set<String> set) {

		if (start == target)
			return 0;

		if (!set.contains(target))
			return 0;

		int level = 0;
		int wordlength = start.length();
		Queue<String> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			++level;
			int sizeofQ = queue.size();
			for (int i = 0; i < sizeofQ; ++i) {

				char[] word = queue.peek().toCharArray();
				queue.remove();

				for (int pos = 0; pos < wordlength; ++pos) {

					char orig_char = word[pos];

					for (char c = 'a'; c <= 'z'; ++c) {
						word[pos] = c;

						if (String.valueOf(word).equals(target))
							return level + 1;

						if (!set.contains(String.valueOf(word)))
							continue;
						
						set.remove(String.valueOf(word));
						queue.add(String.valueOf(word));
					}
					word[pos] = orig_char;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("poon");
		set.add("plee");
		set.add("same");
		set.add("poie");
		set.add("plie");
		set.add("poin");
		set.add("plea");
		String start = "toon";
		String target = "plea";
		System.out.print("Length of shortest chain is: " + shortestChainLen(start, target, set));
	}
}
