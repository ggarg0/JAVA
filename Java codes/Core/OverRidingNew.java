class Animal{
	// public void speak() throws NoSuchFieldException{
	//public void speak() throws NullPointerException{
	//public void speak() throws Exception{
	public static void speak(){
			System.out.println("I am an  Animal");
	}
	/*void run(){
			System.out.println("Animal is running");
	}*/
}

class Dog extends Animal {
 	//public void speak() throws NullPointerException{
	//public void speak() throws NoSuchFieldException{
	//public void speak() throws Exception{
	public static void speak() {
			System.out.println("I am a Dog");
	}
}

class OverRidingNew{
	public static void main(String args[]){
		try{
		Animal aniobj=new Dog();
		aniobj.speak();
		//aniobj.run();

	}
	catch (Exception e){}
	}
}

/* Note: Identify the error, rectify the same and get the output. */