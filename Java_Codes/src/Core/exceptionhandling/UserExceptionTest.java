package Core.exceptionhandling;

class InvalidAmount extends Exception {
	public InvalidAmount() {
		super("Invalid Amount");
	}

	public InvalidAmount(String msg) {
		super(msg);
	}
}

class ZeroAmount extends Exception {
	public ZeroAmount() {
		super("Zero amount not allowed");
	}

	public ZeroAmount(String msg) {
		super(msg);
	}
}

public class UserExceptionTest {
	public static void main(String arg[]) {
		int amount = -1;
		try {
			if (amount < 0) {
				throw new ZeroAmount();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

/* Note: Analyze the code and understand the output. */