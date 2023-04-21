package Collections;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        try {
            List<Object> list = new ArrayList<Object>();
            list.add(5);
            list.add(2);
            list.add(2);
            list.add(4);
            list.add(11);
            System.out.println("List: " + list);
            System.out.println("Size is " + list.size());

            list.add(4, "jack");
            System.out.println("List: " + list);
            System.out.println("Element at index 4 is " + list.get(4));

            list.remove(4);
           // list.remove("jack");
            System.out.println("List after removal : " + list);

            List<Object> remove = new ArrayList<Object>();
            remove.add(3);
            remove.add(4);
            list.removeAll(remove);
            System.out.println("List after removeAll : " + list);

            list.addAll(1, remove);
            System.out.println("List after addAll : " + list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
