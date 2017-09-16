class Typecasting
{
	public static void main(String arg[])
	{

		 long longNumber=200;

		 float floatNumber=123.5F;
		 double doubleNumber=12.5;
		/* explicit type Casting NOT required to convert from float to double */
		 doubleNumber=floatNumber;
		 /* explicit type casting REQUIRED to convert from float to long */
		 //longNumber=(long)floatNumber;
		 longNumber=floatNumber;

	    System.out.println(doubleNumber);
	    System.out.println(longNumber);

 	}
}