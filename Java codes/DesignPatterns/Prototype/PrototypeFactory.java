package DesignPatterns.Prototype;

interface Mall extends Cloneable {
	public Mall clone() throws CloneNotSupportedException;
}

class Movie implements Mall {
	@Override
	public Movie clone() throws CloneNotSupportedException {
		System.out.println("Cloning Movie object..");
		return (Movie) super.clone();
	}
}

class Show implements Mall {
	@Override
	public Show clone() throws CloneNotSupportedException {
		System.out.println("Cloning Show object..");
		return (Show) super.clone();
	}
}

public class PrototypeFactory {
	public static final String MOVIE = "Movie";
	public static final String SHOW = "Show";

	public static Mall getInstance(final String ref) throws CloneNotSupportedException {

		switch (ref) {
		case MOVIE:
			return new Movie().clone();

		case SHOW:
			return new Show().clone();

		default:
			return null;
		}
	}
}
