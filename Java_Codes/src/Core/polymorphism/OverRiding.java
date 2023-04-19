package Core.polymorphism;

abstract class Animal {
	abstract void speak();

	void say() {
		System.out.println("I am an  Animal SAy");
	}
}

class Dog extends Animal {
	void speak() {
		System.out.println("I am a Dog");
	}
}

class Cat extends Animal {
	void speak() {
		System.out.println("I am a cat");
	}
}

class Bulldog extends Dog {
	void speak() {
		System.out.println("I am a BullDog");
	}
}

class OverRiding {
	public static void main(String args[]) {
		Animal aniobj = null;
		aniobj = new Cat();
		aniobj.speak();
		aniobj = new Dog();
		aniobj.speak();
		aniobj = new Bulldog();
		aniobj.speak();
		aniobj.say();
	}
}
