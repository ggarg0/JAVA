package Core.core;

public class HashAndEqualsDemo {
	public static void main(String[] a) {
		HashAndEquals e1 = new HashAndEquals(21, "gaurav");
		HashAndEquals e2 = new HashAndEquals(21, "gaurav");

		System.out.println("Hash : " + e1.hashCode());
		System.out.println("Hash : " + e2.hashCode());
		System.out.println("Equals : " + e1.equals(e2));
	}
}

class HashAndEquals {

	private int id;
	private String name;

	public HashAndEquals(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/*
	 * public int hashCode() { return id * 31; }
	 */

	public boolean equals(Object obj) {
		boolean flag = false;
		HashAndEquals emp = (HashAndEquals) obj;
		if (emp.id == this.id)
			flag = true;
		return flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
