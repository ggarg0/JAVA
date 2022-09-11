package DesignPatterns.Factory;

interface Computer {
	public abstract int getRAM();
}

class PC implements Computer {
	private final int ram = 16;

	@Override
	public int getRAM() {
		return this.ram;
	}
}

class Server implements Computer {
	private final int ram = 32;

	@Override
	public int getRAM() {
		return this.ram;
	}
}

public class ComputerFactory {
	public static Computer getComputer(String type) {
		if ("PC".equalsIgnoreCase(type))
			return new PC();
		else if ("Server".equalsIgnoreCase(type))
			return new Server();

		return null;
	}
}