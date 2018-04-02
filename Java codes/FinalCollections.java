import java.util.*;

public class FinalCollections
{
	public static void main(String a1[])
	{
		try
		{
		final List<String> obj = new ArrayList<String>();
		obj.add("garg");
		obj.add("gaurav");
		obj.add("alan");
		System.out.println("List : " + obj);
		Collections.sort(obj);
	//	obj =  new LinkedList<String>();
		System.out.println("List : " + obj);
		System.out.println("List : " + obj.get(1));
}
catch(Exception e)
{

	}
	}
}