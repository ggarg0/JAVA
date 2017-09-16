import java.util.*;

public class StringSort{
public static void main(String[] args){
    String wordSt="ucbejsndgff";
    char[] word=wordSt.toCharArray();

// Using Loop
    for(int i=0;i<(word.length-1);i++){
        for(int j=i+1;j>0;j--){
            if(word[j]<word[j-1]){
                char temp=word[j-1];
                word[j-1]=word[j];
                word[j]=temp;
            }
        }
    }
    wordSt=String.valueOf(word);
    System.out.println("Using Loop : " + wordSt);

// Using sort function
     Arrays.sort(word);
     String sorted = new String(word);
     System.out.println("Using sort function : " + sorted);
}
}