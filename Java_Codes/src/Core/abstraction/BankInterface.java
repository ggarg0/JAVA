package Core.abstraction;

interface Account {
	default public int getRate(){
		return 0;
	}
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
	public int getOverdraft() {
		return 6;
	}
}

class LoanAccount implements Account {
	public int getLoanRate() {
		return 8;
	}
}

public class BankInterface {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount();
		System.out.println(sa.getRate());

		CheckinAccount ca = new CheckinAccount();
		System.out.println(ca.getOverdraft());

		LoanAccount loan = new LoanAccount();
		System.out.println(loan.getRate());
	}
}
