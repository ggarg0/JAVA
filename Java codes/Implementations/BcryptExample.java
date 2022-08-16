package Implementations;


public class BcryptExample {
	public static void main(String[] args) {
		String originalPassword = "4321";
		String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(4));
		System.out.println(generatedSecuredPasswordHash);

		boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
		System.out.println(matched);
	}
}
