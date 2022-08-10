package Implementations;


public class BcryptExample {
	public static void main(String[] args) {
		String originalPassword = "allsomebody";
		String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(10));
		System.out.println(generatedSecuredPasswordHash);

		boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
		System.out.println(matched);
	}
}