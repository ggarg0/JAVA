package Core;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		String version = "8.1.08";
		System.out.println(Arrays.stream(version.split("\\.")).map(s -> String.format("%02d", Integer.parseInt(s))).collect(Collectors.joining(".")));				
        System.out.println(Arrays.stream(version.split("\\.")).map(s -> (s.length() <2) ? String.format("%02d", Integer.parseInt(s)): s).collect(Collectors.joining(".")));
		System.out.println(version);
	}
}