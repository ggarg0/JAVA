public class Test
{
public static void main(String arg[])
{

	 public static boolean isStringOnlyAlphabet(String str)
	    {
	        return ((str != null)
	                && (!str.equals(""))
	                && (str.matches("^[a-zA-Z]*$")));
	    }

	    // Main method
	    public static void main(String[] args)
	    {

	        // Checking for True case
	        System.out.println("Test Case 1:");

	        String str1 = "GeeksforGeeks";
	        System.out.println("Input: " + str1);
	        System.out.println("Output: " + isStringOnlyAlphabet(str1));

	        // Checking for String with numeric characters
	        System.out.println("\nTest Case 2:");

	        String str2 = "Geeks4Geeks";
	        System.out.println("Input: " + str2);
	        System.out.println("Output: " + isStringOnlyAlphabet(str2));

	        // Checking for null String
	        System.out.println("\nTest Case 3:");

	        String str3 = null;
	        System.out.println("Input: " + str3);
	        System.out.println("Output: " + isStringOnlyAlphabet(str3));

	        // Checking for empty String
	        System.out.println("\nTest Case 4:");

	        String str4 = "";
	        System.out.println("Input: " + str4);
	        System.out.println("Output: " + isStringOnlyAlphabet(str4));
    }
}
}
