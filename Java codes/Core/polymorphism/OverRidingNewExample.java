package Core.polymorphism;

class Animal44 {
	static void speak() {
		System.out.println("I am an  Animal");
	}
}

class Dog44 extends Animal44 {
	static void speak() {
		System.out.println("I am a Dog");
	}

	void run() {
		System.out.println("Dog is running");
	}
}

class OverRidingNewExample {
	public static void main(String args[]) {
		Animal44 aniobj = new Dog44();
		aniobj.speak();
		// aniobj.run();
	}
}
