import java.util.*;
import java.text.*;

class test2{

public static void main(String[] a)
{
	StringBuffer buffer = new StringBuffer();
	boolean whiteFound = true;
	String str = "A SENTENCE WITH A ERROR IN THE HITCHHIKER'S GUIDE TOT HE GALAXY.\n" +
	"   THESE IS A TEST OF SPEL CHECKE USIN LANGUAG TOL.TODAY WAS WEDNSDAY. TOMOROW I CAN TET ASO.";
	int count = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i) == '.' || str.charAt(i) == '\n') {
			whiteFound = true;
			count = 0;
			buffer.append(str.charAt(i));
		} else if (whiteFound) {
			if(str.charAt(i) == ' '){
				buffer.append(str.charAt(i));
				continue;
			}
			else{
				whiteFound = false;
						if (count == 0) {
							buffer.append(Character.toUpperCase(str.charAt(i)));
						} else {
							buffer.append(Character.toLowerCase(str.charAt(i)));
							count += 1;
			}
			}


		} else if (i == 0) {
				buffer.append(Character.toUpperCase(str.charAt(i)));
		} else {
				buffer.append(Character.toLowerCase(str.charAt(i)));
		}
	}
System.out.println("result :  " + buffer.toString());//); buffer.toString();
}
}
