/* This dems shows the usage of arraylist without the support of
Generics ( added from jdk1.5) onwards
*/
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo{
    public static void main(String[] args){
		Set <String>hashset=new HashSet <String>();
		hashset.add("jack");
		hashset.add("tom");
		hashset.add("jerry");


		hashset.add("Jerry");
		hashset.add("12");
		hashset.add("jerry");


		Iterator iterator = hashset.iterator();
	    while (iterator.hasNext()){
	            System.out.println(iterator.next());
        }
	}
}

/*
Remove the comment and
execute the program again check the output
*/
