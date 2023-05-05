package Core.string;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Java");
        str.append(" Learning");
        str.reverse();
        System.out.println(str);
    }
}
