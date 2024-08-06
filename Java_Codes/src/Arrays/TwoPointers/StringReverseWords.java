package Arrays.TwoPointers;

public class StringReverseWords {
    public static String reverseString(String s) {
        StringBuilder ans = new StringBuilder();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (!temp.equals("")) {
                    ans.insert(0, temp + " ");
                }
                temp = "";
            } else {
                temp += ch;
            }
        }
        if (!temp.equals("")) {
            ans.insert(0, temp + " ");
        }
        return ans.toString().trim();
    }

    public static String reverseWordsWithSplit(String stringToReverse) {
        String[] words = stringToReverse != null ? stringToReverse.split(" ") : new String[0];
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
            reversed.append(words[i] + " ");

        return reversed.toString().trim().isEmpty() ? "Empty string" : reversed.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("**********************************************");
        String test = "We Love Java.";
        System.out.println("String input : " + test);
        System.out.println("**********************************************");
        System.out.println("Using two pointer : " + reverseString(test));
        System.out.println("**********************************************");
        System.out.println("Using split function : " + reverseWordsWithSplit(test));
        System.out.println("**********************************************");
    }
}
