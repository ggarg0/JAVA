package com.test;

import java.util.ArrayList;
import java.util.List;

public class MemoryAnalyzer {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		while (1 < 2) {
			list.add("OutOfMemoryError soon");
		}
	}
}
