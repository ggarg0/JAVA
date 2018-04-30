import java.util.*;

public class StringReverse{
public static void main(String[] args){

    String wordSt="garg";
    char[] word=wordSt.toCharArray();
 	int right = word.length-1;

// Using Loop
    for(int left=0;left<right;left++,right--){
	   char temp = word[left];
	   word[left] = word[right];
	   word[right] = temp;
    }
    wordSt=new String(word);
    System.out.println("Using Loop : " + wordSt);

// Using sort function
  	 String wordSt1="gauravs";
	 StringBuilder st = new StringBuilder();
	 st.append(wordSt1);
     st = st.reverse();
     System.out.println("Using reverse function : " + st);
}
}