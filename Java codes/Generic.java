class GenNumber<T extends Number>{
	T number;
	GenNumber(T number){
		this.number=number;
	}
	void disp(){
		System.out.println("value is "+number);
	}
}

class Generic{
	public static void main(String arg[])	{
		GenNumber<Integer> genInteger=new GenNumber<Integer>(10);
		GenNumber<Double> genDouble=new GenNumber<Double>(10.55);
		genInteger.disp();
		genDouble.disp();
	}
}

