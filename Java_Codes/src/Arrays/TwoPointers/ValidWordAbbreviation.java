package Arrays.TwoPointers;

//https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-valid-word-abbreviation

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                if (abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int num = 0;

                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                wordIndex += num;
            } else {
                if (wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static void main(String[] args) {
        String[] words = {"a", "a", "word", "internationalization"};
        String[] abbreviations = {"a", "b", "w0rd", "i18n"};

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\t word: '" + words[i] + "'");
            System.out.println("\t abbr: '" + abbreviations[i] + "'");
            System.out.println("\n\t Is '" + abbreviations[i] + "' a valid abbreviation for the word '" + words[i]
                    + "'? " + (validWordAbbreviation(words[i], abbreviations[i]) ? "Yes" : "No"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
