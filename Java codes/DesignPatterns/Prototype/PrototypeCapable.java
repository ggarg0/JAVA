package DesignPatterns.Prototype;

public interface PrototypeCapable extends Cloneable {
	public PrototypeCapable clone() throws CloneNotSupportedException;
}