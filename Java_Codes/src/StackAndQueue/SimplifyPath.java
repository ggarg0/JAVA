package StackAndQueue;

import java.util.Stack;

public class SimplifyPath {

	public static String simplifyPath(String path) {
		Stack<String> s = new Stack<>();
		StringBuilder res = new StringBuilder();
		String[] p = path.split("/");

		for (int i = 0; i < p.length; i++) {
			if (!s.isEmpty() && p[i].equals(".."))
				s.pop();
			else if (!p[i].isEmpty() && !p[i].equals(".") && !p[i].equals(".."))
				s.push(p[i]);
		}

		if (s.isEmpty())
			return "/";
		while (!s.isEmpty()) {
			res.insert(0, s.pop()).insert(0, "/");
		}

		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home//foo/"));

	}

}
