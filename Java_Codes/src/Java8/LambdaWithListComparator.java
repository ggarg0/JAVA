package Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
	int id;
	String name;
	double price;

	@Override
	public String toString() {
		return "\nProduct {" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class LambdaWithListComparator {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(10, "Laptop", 25000.00d));
		list.add(new Product(30, "Keyboard", 300.00d));
		list.add(new Product(20, "Mouse", 150.00d));
		list.add(new Product(50, "Desktop", 20000.00d));
		list.add(new Product(40, "Monitor", 1500.00d));

		System.out.println("Sorting by Id ascending...");
		Collections.sort(list, (o1, o2) -> o1.id - o2.id);
		System.out.println(list.toString());
		System.out.println();

		System.out.println("Sorting by Id descending...");
		Collections.sort(list, (o1, o2) -> o2.id - o1.id);
		System.out.println(list.toString());
		System.out.println();

		System.out.println("Sorting by name ascending...");
		Collections.sort(list, (o1, o2) -> { return o1.name.compareTo(o2.name); } );
		System.out.println(list.toString());
		System.out.println();

		System.out.println("Sorting by name descending...");
		Collections.sort(list, (o1, o2) -> { return o2.name.compareTo(o1.name); } );
		System.out.println(list.toString());
		System.out.println();

		System.out.println("Sorting by price ascending...");
		Collections.sort(list, (o1, o2) -> (int) (o1.price - o2.price));
		System.out.println(list.toString());
		System.out.println();

		System.out.println("Sorting by price descending...");
		Collections.sort(list, (o1, o2) -> (int) (o2.price - o1.price));
		System.out.println(list.toString());
		//list.forEach(Product -> System.out.print(Product.price + " "));
		System.out.println();

	}
}