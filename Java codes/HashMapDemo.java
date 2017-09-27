import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo{
    public static void main(String[] args){
		Map hashmap=new HashMap();

		hashmap.put(1001,"Jerry");
		hashmap.put(1005,"12");
		hashmap.put(1003,"Mary");

		hashmap.put(1002,"jack");
		hashmap.put(1004,"Jerry");

		Set set=hashmap.keySet();
		Iterator iterator = set.iterator();

	    while (iterator.hasNext()){
	            Integer key=(Integer)iterator.next();
	            System.out.print(key + " = ");
	            System.out.println((String)hashmap.get(key) + " and : ");
        }
	}
}
/*
	Remove the comments recompile and execute the program
*/


