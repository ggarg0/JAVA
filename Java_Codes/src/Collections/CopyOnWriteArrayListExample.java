package Collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample{
    public static void main(String args[]) {
        CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
        threadSafeList.add("Java");
        threadSafeList.add("J2EE");
        threadSafeList.add("Collection");

        //add, remove operator is not supported by CopyOnWriteArrayList iterator
        Iterator<String> failSafeIterator = threadSafeList.iterator();
        while(failSafeIterator.hasNext()){
          
            threadSafeList.remove("J2EE"); //not supported in CopyOnWriteArrayList in Java
            System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
        }
        
        Iterator<String> failSafeIterator1 = threadSafeList.iterator();
        while(failSafeIterator1.hasNext()){
          
           
            System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator1.next());
        }
    }
}
