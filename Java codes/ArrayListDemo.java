/* This dems shows the usage of arraylist without the support of
Generics ( added from jdk1.5) onwards
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class ArrayListDemo{
    public static void main(String[] args){
		try
		{
        List arraylist = new ArrayList();
		System.out.println("Size now ="+arraylist.size());
		System.out.println("Size now ="+arraylist.size());

        for (int i = 0; i < 5; i++){
            arraylist.add(new Integer(i));
        }

        arraylist.add("jack");

        System.out.println("Size now ="+arraylist.size());
        System.out.println("6 now ="+arraylist.get(5));
		Integer num=null;
		for(int i=0;i<=arraylist.size();i++){
			System.out.println(arraylist.get(i));
			num=(Integer)arraylist.get(i);
			System.out.println(num);
		}
	}
	catch(Exception e)
	{}
	}
}

/*
Remove the comment for arraylist.add("jack");
execute the program again check the output
*/
