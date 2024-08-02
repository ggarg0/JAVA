package Arrays.TwoPointers;

public class StringReverseWords {
    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }

    public static String reverseWords(String sentence) {
     //   sentence = sentence.replaceAll("\\s+", " ").trim();
        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;
        strRev(charArray, 0, strLen);
        for (int start = 0, end = 0; end <= strLen; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                int endIdx = (end == strLen) ? end : end - 1;
                strRev(charArray, start, endIdx);
                start = end + 1;
            }
        }
        return new String(charArray);
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
        System.out.println("Using two pointer : " + reverseWords(test));
        System.out.println("**********************************************");
        System.out.println("Using split function : " + reverseWordsWithSplit(test));
        System.out.println("**********************************************");
    }
}
