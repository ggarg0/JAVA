package Core.core;

public class Java_Enum {

	enum Color {
		RED, GREEN, BLUE;
	}

	public static void main(String[] args) {
		System.out.println(Color.GREEN);
		System.out.println(Color.valueOf("RED"));

	}
}
