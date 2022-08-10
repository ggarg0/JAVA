package Core;
interface GenNumberInterface<T extends Number>{
	void display(T number);
}

class GenNumberClass<T extends Number> implements GenNumberInterface<T>{

	public void display(T  number){
		System.out.println(number);
	}
}

class GenericInterface{
	public static void main(String arg[]){
		GenNumberClass <Integer>object1=new GenNumberClass<Integer>();
		object1.display(new Integer(1));
		GenNumberClass <Long>object2=new GenNumberClass<Long>();
		object2.display(new Long(10));
	}
}

/* Note: Analyze the code and understand the output. */