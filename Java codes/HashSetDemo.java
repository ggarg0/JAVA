/* This dems shows the usage of arraylist without the support of
Generics ( added from jdk1.5) onwards
*/
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo{
    public static void main(String[] args){
		Set hashset=new HashSet();
		hashset.add("jack");
		hashset.add("tom");
		hashset.add("2");
		hashset.add("jerry");
		hashset.add("Jerry");

		Iterator iterator = hashset.iterator();
	   while (iterator.hasNext()){
				String o= (String) iterator.next();
	            System.out.println("Old : " + o);
	           if(o.equals("2"))  {
				   iterator.remove();
				   break;
      			}
        }
        iterator = hashset.iterator();
			    while (iterator.hasNext()){
						String o= (String) iterator.next();
						  System.out.println("New : " + o);
			                 }

	}
}

/*
Remove the comment and
execute the program again check the output
*/
