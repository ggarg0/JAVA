package Collections;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> hashset = new HashSet<String>();
        hashset.add("jack");
        hashset.add("Tom");
        hashset.add("2");
        hashset.add("jerry");
		hashset.add("jerry");
        hashset.add("Jerry");       
        System.out.println("Content: " + hashset);
        hashset.remove("jack");
        System.out.println("Content: " + hashset);
        
        Iterator<String> it = hashset.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("value : " + value);
            if (value.equalsIgnoreCase("tom")) {
                it.remove();
              //  hashset.add("tom");
            }
        }
        
		System.out.println("Content: " + hashset);
    }
}


