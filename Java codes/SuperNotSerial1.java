import java.io.*;

class SuperNotSerial1
{
	public static void main(String[] a)
	{
		Dog d = new Dog(12,"Gaurav");
		System.out.println("Before Serial name : "+d.name+ " & weight : " + d.weight);
		try
		{
			FileOutputStream fos = new FileOutputStream("SuperNotSerial.txt");
			ObjectOutputStream bos = new ObjectOutputStream(fos);
			bos.writeObject(d);
			bos.close();
		}
		catch(Exception e)
		{
			System.out.println("EXP : " + e);
		}

		try
				{
					//d.name="Changed Name";
					//d.weight=123;
					//System.out.println("Change after serial name : "+d.name+ " & weight : " + d.weight);
					FileInputStream fis = new FileInputStream("SuperNotSerial.txt");
					ObjectInputStream bis = new ObjectInputStream(fis);
					d= (Dog) bis.readObject();
					bis.close();
				}
				catch(Exception e)
				{
					System.out.println("EXP : " + e);
		}
		System.out.println("Recovered object name : "+d.name+ " & weight : " + d.weight);
	}
}
class Dog extends Animal implements Serializable
{
	String name;
	Dog(int w, String n)
	{
		weight=w;
		name=n;
	}
}
class Animal
{
	 static int weight=42;
	 //int weight;
}