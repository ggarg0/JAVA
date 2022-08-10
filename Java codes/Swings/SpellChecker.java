package Swings;
public class SpellChecker {

	public static void main(String[] args) {
			String msg = "A sentence with a error in the Hitchhiker's Guide tot he Galaxy.These is a test of spel checke usin languag tol ja. Today was Wednsday. tomorow I can tet aso.";

			System.out.println("Before Replace : " + msg);

			StringBuilder messageStartText = new StringBuilder(msg.substring(0, 16));
			messageStartText.append("an");
			StringBuilder endMessageText = new StringBuilder(msg.substring(17, msg.length()));
			messageStartText.append(endMessageText);

			System.out.println("After Replace : " + messageStartText);

	}

}
