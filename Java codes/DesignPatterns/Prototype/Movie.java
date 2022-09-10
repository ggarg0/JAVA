package DesignPatterns.Prototype;

public class Movie implements PrototypeCapable {
	@Override
	public Movie clone() throws CloneNotSupportedException {
		System.out.println("Cloning Movie object..");
		return (Movie) super.clone();
	}

	@Override
	public String toString() {
		return "Movie";
	}
}

