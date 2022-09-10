package DesignPatterns.Prototype;

public class Show implements PrototypeCapable {
	@Override
	public Show clone() throws CloneNotSupportedException {
		System.out.println("Cloning Show object..");
		return (Show) super.clone();
	}

	@Override
	public String toString() {
		return "Show";
	}
}