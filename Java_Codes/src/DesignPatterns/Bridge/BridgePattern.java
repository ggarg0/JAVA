package DesignPatterns.Bridge;

abstract class Vehicle {
	protected Workshop workShop;

	protected Vehicle(Workshop workShop) {
		this.workShop = workShop;
	}
	abstract public void service();
}

class Car extends Vehicle {
	public Car(Workshop workShop) {
		super(workShop);
	}

	@Override
	public void service() {
		System.out.print("Car ");
		workShop.work();
	}
}

class Bike extends Vehicle {
	public Bike(Workshop workShop) {
		super(workShop);
	}

	@Override
	public void service() {
		System.out.print("Bike ");
		workShop.work();

	}
}

interface Workshop {
	abstract public void work();
}

class Service implements Workshop {
	@Override
	public void work() {
		System.out.print("Service");
		System.out.println();
	}
}

class BridgePattern {
	public static void main(String[] args) {
		Vehicle vehicle1 = new Car(new Service());
		vehicle1.service();
		Vehicle vehicle2 = new Bike(new Service());
		vehicle2.service();
	}
}
