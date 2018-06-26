
public class AnagramProgram {

	public static void main(String[] args) {
		String input1= "caa";
		String input2 = "aca";
		AnagramProgram obj = new AnagramProgram();
		System.out.println("Result : " + obj.isAnagram(input1, input2));
	}

	  public boolean isAnagram(String word, String anagram) {
		  System.out.println(word + " and " + anagram);
		  boolean isAnagram = false;
	        if (word != null && anagram != null && word.length() == anagram.length()) {
	            char[] arr = word.toCharArray();
	            StringBuilder temp = new StringBuilder(anagram);
	            int wordLength = word.length();
	            for (char ch : arr) {
	                int index = temp.indexOf("" + ch);
	                if (index != -1) {
	                    temp.deleteCharAt(index);
	                }
	            }
	            isAnagram = temp.toString().isEmpty();
	        }
	        return isAnagram;
	    }


}
