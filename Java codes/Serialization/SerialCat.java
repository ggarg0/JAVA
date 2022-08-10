package Serialization;
import java.io.*;

class Cat11 implements Serializable {}

public class SerialCat
{
public static void main(String[] a)
{
	Cat11 c=new Cat11();
	try
	{
		FileOutputStream fs=new FileOutputStream("TestSer.dat");
		ObjectOutputStream obj=new ObjectOutputStream(fs);
		obj.writeObject(c);
		obj.close();


		FileInputStream fis = new FileInputStream("TestSer.ser");
		ObjectInputStream obi = new ObjectInputStream(fis);
		c=(Cat11) obi.readObject();
		obi.close();
	}
	catch(Exception e)
		{
		 	System.out.println("Exp : " + e);
	}

}

}