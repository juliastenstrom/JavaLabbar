package lab3;

public class CurrentAccount extends Account{
	
	public CurrentAccount(String arg1, double arg2) {
		super(arg1, arg2);
		super.otherAccount = null;
	}
	
	public CurrentAccount (String arg1, double arg2, double arg3) {
		super(arg1, arg2, arg3);
	}
	
	
	public void savings (double arg) {
		
		double balance = getBalance();
		double savings = otherAccount.getBalance();

		if(arg > 0) {
			if(arg > balance) {
				arg = balance;
				otherAccount.setBalance(savings+arg);
				setBalance(0);
			}	
			else {
				otherAccount.setBalance(savings+arg);
				setBalance(balance-arg);
			}
		} else {
			if(savings + arg < 0) {
				arg = -savings;
				otherAccount.setBalance(0);
				setBalance(balance-arg);
			}
			else {
				otherAccount.setBalance(savings+arg);
				setBalance(balance-arg);
			}
		}
		if(arg > 0) {
			otherAccount.transactions.add("From savings account: " + arg);
			transactions.add("To current account: " + arg);
		} else {
			otherAccount.transactions.add("To savings account: " + (-arg));
			transactions.add("From current account: " + (-arg));
			
		}
	}
	
	public void send(double arg1, CurrentAccount arg2) {
		this.setBalance(this.getBalance() - arg1);
		arg2.receive(getCustomer(), arg1);
		transactions.add("Sent to account of " + arg2.getCustomer() + ": " + arg1);
		
		
		if(getBalance() < 0 && otherAccount != null && otherAccount.getBalance() > 0.0) {
			savings(getBalance());
		} 
		if (getBalance() <  0){
			theBank.getLoan(this);
			transactions.add("Covered by loan " + (-getBalance()));
			this.setBalance(0);
		}
	}
	
	public void receive(String arg1, double arg2) {
		this.setBalance(getBalance() + arg2);
		if("Cash payment".equals(arg1)) {
			transactions.add("Cash payment: " + arg2);
		}
		else {
			transactions.add("Received from account of " + arg1 + ": " + arg2);
		}
	}
	
}
