package Core.abstraction;

interface Account {
	public int getRate();
}

class SavingsAccount implements Account {
	public int getRate() {
		return 8;
	}
}

class CheckinAccount implements Account {
	public int getRate() {
		return 4;
	}
}

public class BankInterface {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount();
		System.out.println(sa.getRate());

		CheckinAccount ca = new CheckinAccount();
		System.out.println(ca.getRate());
	}

}
