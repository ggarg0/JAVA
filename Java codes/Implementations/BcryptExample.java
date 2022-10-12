package Implementations;


public class BcryptExample {
	public static void main(String[] args) {
		String originalPassword = "1234";
		String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(10));
		System.out.println(generatedSecuredPasswordHash);

		boolean matched = BCrypt.checkpw("1234", generatedSecuredPasswordHash);
		System.out.println(matched);
	}
}
