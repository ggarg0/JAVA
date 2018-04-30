class Swap
{
	public static void main (String []a1){

	try{
		int a = 70, b = 50;

		System.out.println("value of a and b before swapping, a: " + a +" b: " + b);

		//swapping value of two numbers without using temp variable
		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("value of a and b after swapping, a: " + a +" b: " + b);

	}
	catch(Exception e)
	{}
	}
}