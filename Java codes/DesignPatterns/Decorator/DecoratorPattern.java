package DesignPatterns.Decorator;

abstract class Pizza {
	String description = "Unkknown Pizza";
	public String getDescription() {
		return description;
	}

	public abstract int getCost();
}

class FarmHouse extends Pizza {
	public FarmHouse() {
		description = "FarmHouse";
	}

	public int getCost() {
		return 200;
	}
}

class SimplePizza extends Pizza {
	public SimplePizza() {
		description = "SimplePizza";
	}

	public int getCost() {
		return 50;
	}
}

abstract class ToppingsDecorator extends Pizza {
	public abstract String getDescription();
}

class FreshTomato extends ToppingsDecorator {
	Pizza pizza;

	public FreshTomato(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Fresh Tomato ";
	}

	public int getCost() {
		return 40 + pizza.getCost();
	}
}

public class DecoratorPattern {
	public static void main(String args[]) {
		Pizza pizza = new SimplePizza();
		System.out.println(pizza.getDescription() + " Cost :" + pizza.getCost());

		Pizza pizza2 = new FarmHouse();
		pizza2 = new FreshTomato(pizza2);
		System.out.println(pizza2.getDescription() + " Cost :" + pizza2.getCost());
	}
}
