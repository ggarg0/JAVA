import java.io.*;

class Cat implements Serializable {}

public class SerialCat
{
public static void main(String[] a)
{
	Cat c=new Cat();
	try
	{
		FileOutputStream fs=new FileOutputStream("TestSer.ser");
		ObjectOutputStream obj=new ObjectOutputStream(fs);
		obj.writeObject(c);
		obj.close();

	}
	catch(Exception e)
	{
	 	System.out.println("Exp : " + e);
	}
	try
	{
		FileInputStream fis = new FileInputStream("TestSer.ser");
		ObjectInputStream obi = new ObjectInputStream(fis);
		c=(Cat) obi.readObject();
		obi.close();
	}
	catch(Exception e)
		{
		 	System.out.println("Exp : " + e);
	}

}

}