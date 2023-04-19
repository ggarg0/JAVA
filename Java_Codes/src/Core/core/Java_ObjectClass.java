package Core.core;

public class Java_ObjectClass implements Cloneable {

	private String title;
	private String author;
	private int year;

	public Java_ObjectClass(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	// Override the toString method
	@Override
	public String toString() {
		return title + " by " + author + " (" + year + ")";
	}

	// Override the hashCode method
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + title.hashCode();
		result = 31 * result + author.hashCode();
		result = 31 * result + year;
		return result;
	}

	// Override the clone method
	@Override
	public Java_ObjectClass clone() {
		try {
			return (Java_ObjectClass) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	protected void finalize() throws Throwable {
		System.out.println("Finalizing " + this);
		System.gc();
	}

	public static void main(String[] args) {
		try {
			// Create a object and print its details
			Java_ObjectClass book1 = new Java_ObjectClass("Java", "Oracle", 1991);
			System.out.println("toString : " + book1.toString());

			// Create a clone of the object and print its details
			Java_ObjectClass book2 = book1.clone();
			System.out.println("clone : " + book2);

			Java_ObjectClass book3 = book1;
			//	book3.setAuthor("Sun");
			// book2.setAuthor("Sun");

			// Check if the two objects are equal
			System.out.println("book1 equals book2: " + book1.equals(book2));
			System.out.println("book1 equals book3: " + book1.equals(book3));
		
			// Get the hash code of the two objects
			System.out.println("book1 hash code: " + book1.hashCode());
			System.out.println("book2 hash code: " + book2.hashCode());
			System.out.println("book3 hash code: " + book3.hashCode());

			System.out.println("Java_ObjectClass object: " + book2.getClass().getName());

			book1.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
