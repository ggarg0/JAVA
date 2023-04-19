package Strings;

class StringDemo{
	public static void main(String arg[]){
			String name=new String("Infosys");
			String name1= new String("Infosys");
			String name2 = "Infosys";
			String name3 = "Infosys";
			//String empty = s.trim();
			//System.out.println(empty.isEmpty());

			/* Refer java documentation for the String class methods */
		//	System.out.println(s + ",");
			//System.out.println(s.toString());
		//	System.out.println(s);
			System.out.println(name.equals(name1));
			System.out.println(name==name1);
			System.out.println(name.equals(name2));
			System.out.println(name==name2);
			System.out.println(name3.equals(name2));
			System.out.println(name3==name2);

			System.out.println("SubString : " + name3.substring(2,3));
 	}
}

/* Note: Analyze the code and understand the output. */