import java.util.*;

public class CollectionsSort
{
	public static void main(String a1[])
	{
		try
		{
		List<String> obj = new ArrayList<String>();
		obj.add("garg");
		obj.add("gaurav");
		obj.add("alan");
		obj.add("den");
		obj.add("tim");
		obj.add("carl");

		System.out.println("List : " + obj);
		Collections.sort(obj);
		System.out.println("List : " + obj);
		System.out.println("List : " + obj.get(1));
}
catch(Exception e)
{

	}
	}
}