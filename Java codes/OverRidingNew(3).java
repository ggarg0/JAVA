class Animal{
	void speak(){
			System.out.println("I am an  Animal");
	}
void run(){
			System.out.println("Dog is running");
	}
}

class Dog extends Animal{
 	void speak(){
			System.out.println("I am a Dog");
	}

}

class OverRidingNew{
	public static void main(String args[]){
		Animal aniobj=new Dog();
		aniobj.speak();
		aniobj.run();
	}
}

/* Note: Identify the error, rectify the same and get the output. */