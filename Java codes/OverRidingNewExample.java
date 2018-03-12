class Animal{
	static void speak(){
		System.out.println("I am an  Animal");
	}
}

class Dog extends Animal{
 	static void speak(){
			System.out.println("I am a Dog");
	}
	void run(){
				System.out.println("Dog is running");
	}
}

class OverRidingNewExample{
	public static void main(String args[]){
		Animal aniobj=new Dog();
		aniobj.speak();
		aniobj.run();
	}
}

/* Note: Identify the error, rectify the same and get the output. */