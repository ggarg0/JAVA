import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapSortKeys {

    public static void main(String[] args) {

         Map<Integer, String> hmap = new HashMap<Integer, String>();
         hmap.put(85, "A");
         hmap.put(81, "C");
         hmap.put(41, "Z");
         hmap.put(77, "Y");

         System.out.println("Before Sorting by keys :");
         Set set = hmap.keySet();
         Iterator iterator = set.iterator();
         while(iterator.hasNext()) {
			   Integer key=(Integer)iterator.next();
			   System.out.print(key);
	           System.out.println(" - " + (String)hmap.get(key));

              /* Map.Entry me = (Map.Entry)iterator.next();
               System.out.print(me.getKey() + ": ");
               System.out.println(me.getValue());*/
         }
         Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
         System.out.println("After Sorting by keys :");

         /*Set set2 = map.entrySet();
         Iterator iterator2 = set2.iterator();
         while(iterator2.hasNext()) {
              Map.Entry me2 = (Map.Entry)iterator2.next();
              System.out.print(me2.getKey() + ": ");
              System.out.println(me2.getValue());
         }*/
          Set set1 = map.keySet();
          Iterator iterator1 = set1.iterator();
		  	while(iterator1.hasNext()) {
		 	   Integer key=(Integer)iterator1.next();
		 	   System.out.print(key);
		       System.out.println(" - " + (String)map.get(key));
         }
    }
}