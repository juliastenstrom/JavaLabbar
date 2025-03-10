package lab3;

public class Loan extends Account{
	
	public Loan(CurrentAccount arg) {
		super(arg);
	}
	
	public double payOff(double arg) {
		setBalance(getBalance() + arg);		
		transactions.add("Paid off: " + arg);
		return getBalance();
	}

}
