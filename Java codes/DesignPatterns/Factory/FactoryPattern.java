package DesignPatterns.Factory;

public class FactoryPattern {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc");
		Computer server = ComputerFactory.getComputer("server");
		System.out.println("Factory PC Config::" + pc.getRAM());
		System.out.println("Factory Server Config::" + server.getRAM());
	}
}