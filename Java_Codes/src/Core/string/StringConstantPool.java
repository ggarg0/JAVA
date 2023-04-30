package Core.string;

public class StringConstantPool {
	public static void main(String[] args) {
		String s = "Java";
		s.concat(" Python");
		System.out.println(s);

		String s1 = "Cat";
		String s2 = "Cat";
		String s3 = new String("Cat");
		System.out.println("s1 == s2 :" + (s1 == s2));
		System.out.println("s1 == s3 :" + (s1 == s3));
	}
}
