package Implementations;


public class BcryptExample {
	public static void main(String[] args) {
		String originalPassword = "pass";
		String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(10));
		System.out.println(generatedSecuredPasswordHash);

		boolean matched = BCrypt.checkpw("pass", generatedSecuredPasswordHash);
		System.out.println(matched);
	}
}
