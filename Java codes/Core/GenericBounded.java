package Core;
class GenNumber11<T extends Number>{
	T number;

	GenNumber11(T number){
		this.number=number;
	}

	void disp(){
		System.out.println("value is "+number);
	}
}

class GenericBounded{
	public static void main(String arg[]){
		GenNumber11<Integer> genInteger=new GenNumber11<Integer>(10);
		GenNumber11<Double> genDouble=new GenNumber11<Double>(10.55);
		GenNumber11 genLong=new GenNumber11(1000L);
		//GenNumber11<String> genString=new GenNumber11<String>("Jack");

		genInteger.disp();
		genDouble.disp();
		genLong.disp();

	}
}

/* Note: Identify the error, rectify the same and get the output. */