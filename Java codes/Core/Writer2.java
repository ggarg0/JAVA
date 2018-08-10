import java.io.*;

class Writer2
{
	public static void main (String []a){
	char[] in=new char[50];
	int size=0;
	try{
		File file= new File("Mine.txt");
		FileWriter fw= new FileWriter(file);
		fw.write("Javafolks");
		fw.flush();
		fw.close();
		FileReader fr=new FileReader(file);
		size=fr.read(in);

		System.out.println(size);
		for(char c : in)
			System.out.print(c);
		fr.close();
	}
	catch(IOException e)
	{}
	}
}