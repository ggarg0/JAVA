package Implementations;

import org.jasypt.util.text.AES256TextEncryptor;

public class JasyptDemo {
	public static void main(String[] args) {
		String password = "dbwriteonly";

		AES256TextEncryptor encryptor = new AES256TextEncryptor();
		encryptor.setPassword("gaurav");
		String myEncryptedText = encryptor.encrypt(password);
		System.out.println("Encrypted: " + myEncryptedText);

		String plainText = encryptor.decrypt(myEncryptedText);
		System.out.println("Decrypted: " + plainText);
	}
}
