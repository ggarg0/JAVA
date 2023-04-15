package Core.polymorphism;

class Animal1 {
	public void speak() throws NoSuchFieldException {
	}

	// public void speak() throws NullPointerException{
	// public void speak() throws Exception{

	//public static void speak() {
	//	System.out.println("I am an  Animal");
	//}
}

class Dog1 extends Animal1 {
	//public void speak() throws NullPointerException {
	//}

	// public void speak() throws NoSuchFieldException{}
	// public void speak() throws Exception{}

	public void speak() {
		System.out.println("I am a Dog");
	}
}

public class OverRidingNew {
	public static void main(String args[]) {
		try {
			Animal1 aniobj = new Dog1();
			aniobj.speak();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
