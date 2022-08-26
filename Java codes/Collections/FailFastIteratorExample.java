package Collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastIteratorExample {
	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> list = new ConcurrentHashMap<Integer, String>();
		list.put(1,"a");
		list.put(2, "b");
		list.put(3, "c");
	
		Iterator<Integer> it = list.keySet().iterator();
        
        while (it.hasNext())
        {
            int key = (int) it.next();
             
            System.out.println(key+" : "+list.get(key));
             if (key == 3) {
                 
                 it.remove();
             }
         
            list.put(4, "d");  
        }
		System.out.println("Out : " + list);
	}
}