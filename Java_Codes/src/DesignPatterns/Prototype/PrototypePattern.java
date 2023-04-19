package DesignPatterns.Prototype;

public class PrototypePattern {
	public static void main(String[] args) {
		try {
			PrototypeFactory.getInstance(PrototypeFactory.MOVIE);
			PrototypeFactory.getInstance(PrototypeFactory.SHOW);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
