package Arrays.General;

import java.util.*;

class ListMissingElement {
    public static void main(String arg[]) {
        Integer[] array1 = {3, 7, 2, 90, 34, 67};
        Integer[] array2 = {2, 7, 34, 3, 67};

        Integer value = 0;
        for (int i = 0; i < array1.length; i++) {
            value += array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            value -= array2[i];
        }
        System.out.println("Missing Number : " + value);

        //Using collections
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(array1));
        l1.removeAll(Arrays.asList(array2));
        System.out.println("Missing Number using list : " + l1);
    }
}