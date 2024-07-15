package StackAndQueue;

public class BalanceParenthesesMinAdd {

    public static int minAdd(String s) {
        int open = 0;
        for (int i =0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            } else{
                open--;
            }
        }
        return open;

    }

    public static void main(String[] args) {
        String input = "())";
        System.out.println(minAdd(input));
    }
}
