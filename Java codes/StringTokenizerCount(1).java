import java.util.StringTokenizer;

public class StringTokenizerCount {
    public static void main(String a[]){
        String msg = "This program gives sample code for String Tokenizer in Java";
        StringTokenizer st = new StringTokenizer(msg,"g");
        while(st.hasMoreTokens()){
			System.out.println(st.nextToken());

			}
System.out.println("Count: "+st.countTokens());
}
}
