class Animal1 {
	public void speak() throws NoSuchFieldException{}
	// public void speak() throws NullPointerException{
	// public void speak() throws Exception{
/*	public static void speak() {
		System.out.println("I am an  Animal");
	}
*/
	void run() {
		System.out.println("Animal is running");
	}

}

class Dog1 extends Animal1 {
	public void speak() throws NullPointerException{}
	// public void speak() throws NoSuchFieldException{
	// public void speak() throws Exception{
/*	public static void speak() {
		System.out.println("I am a Dog");
	}
	*/
	void run() {
		super.run();
		System.out.println("Dog is running");
	}
}

public class OverRidingNew {
	public static void main(String args[]) {
		try {
			Animal1 aniobj = new Dog1();
			aniobj.speak();
			aniobj.run();

		} catch (Exception e) {
		}
	}
}
