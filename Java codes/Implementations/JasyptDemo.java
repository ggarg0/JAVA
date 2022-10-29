package Implementations;

import org.jasypt.util.text.AES256TextEncryptor;

public class JasyptDemo {
	public static void main(String[] args) {
		String password = "dbreadonly";

		AES256TextEncryptor encryptor = new AES256TextEncryptor();
		encryptor.setPassword("$2a$10$UoRTmGNS3FwTJig5NxJFgudSaL1Iee9s/TfrKidcPoMZwRslMl3y2");
		String myEncryptedText = encryptor.encrypt(password);
		System.out.println("Encrypted: " + myEncryptedText);

		String plainText = encryptor.decrypt(myEncryptedText);
		System.out.println("Decrypted: " + plainText);

	}

}
