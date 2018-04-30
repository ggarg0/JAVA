public class Palindrome {

    public static void main(String args[]){
        int palindrome = 12321;

        if(isPalindrome(palindrome)){
            System.out.println("Number : " + palindrome + " is a palindrome");
        }else{
            System.out.println("Number : " + palindrome + " is not a palindrome");
        }
    }

    public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
            System.out.println("palindrome : " + palindrome + ", remainder : " + remainder + ", reverse : " + reverse);
        }
        if (number == reverse) {
            return true;
        }
        return false;
    }

}
