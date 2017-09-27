/* This dems shows the usage of arraylist with the support of
Generics ( added from jdk1.5) onwards
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemoUsingJava5{
    public static void main(String[] args){
        List arraylist = new ArrayList();
		System.out.println("Size now ="+arraylist.size());

		//No ned to create integer Object explicitly because of autoboxing (jdk1.5)

		arraylist.add(10);

		System.out.println("Size now ="+arraylist.size());

        for (int i = 0; i < 5; i++) {
            arraylist.add(new Integer(i));
            System.out.println(arraylist.get(i));
        }
        System.out.println("Size now ="+arraylist.size());

		arraylist.add("jack");

		int number=0;
	 	Iterator iterator = arraylist.iterator();
	 	while (iterator.hasNext()) {
	            System.out.print(iterator.next()+", ");
        }
	}
}

/*
Remove the comment (// arraylist.add("jack");)and compile the program
*/

