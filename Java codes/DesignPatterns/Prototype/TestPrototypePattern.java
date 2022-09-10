package DesignPatterns.Prototype;

public class TestPrototypePattern {
	public static void main(String[] args) {
		try {
			String moviePrototype = PrototypeFactory.getInstance(PrototypeFactory.MOVIE).toString();
			System.out.println(moviePrototype);

			String showPrototype = PrototypeFactory.getInstance(PrototypeFactory.SHOW).toString();
			System.out.println(showPrototype);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
