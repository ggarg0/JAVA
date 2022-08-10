package Strings;

import java.util.StringTokenizer;

public class StringTokenizerCount {
    public static void main(String a[]){
        String msg = "This program gives sample code for String Tokenizer in Java";
        StringTokenizer st = new StringTokenizer(msg," ");
        System.out.println("Count: "+st.countTokens());
        while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}
