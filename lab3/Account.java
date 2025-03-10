package lab3;

import java.util.ArrayList;

public class Account {
	
	private static int accountNumbers = 1;
	private String customer;
	private int thisAccountNumber;
	private double balance;
	protected static Bank theBank = null;
	protected Account otherAccount;
	protected ArrayList<String> transactions = new ArrayList<String>();
	
	
	//Create a new account
	public Account(String arg1, double arg2) { 
		customer = arg1;
		balance = arg2;
		thisAccountNumber = accountNumbers;
		accountNumbers += 1;
	}

	
	//Create an account with the second account ohterAccount
	public Account(String arg1, double arg2, double arg3) {
		customer = arg1;
		balance = arg2;
		thisAccountNumber = accountNumbers;
		otherAccount = new SavingsAccount(arg1, arg3);
		accountNumbers += 1;
	}
	
	public Account(CurrentAccount arg) {
		otherAccount = arg;
		balance = arg.getBalance();
		thisAccountNumber = otherAccount.getAccountNumber();
		customer = otherAccount.getCustomer();
	}
	
	public void annualChange() {
	
		if (this instanceof CurrentAccount) {
			balance = balance - 10;
			if(balance < 0.0) {
				theBank.getLoan((CurrentAccount) this);
				balance = 0.0;
			}
		} else if(this instanceof SavingsAccount) {
			//setBalance(getBalance()*1.01);
			
			
			balance = balance * 1.01;
		} 
		else if (this instanceof Loan) {
			//setBalance(getBalance()*1.05);
			
			balance = balance * 1.05;
		} 
		
	}


	public int getAccountNumber() {
		return thisAccountNumber;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public double getBalance () {
		return balance;
	}
	
	public void setBalance(double arg) {
		balance = arg;
	}
	
	public static void setBank(Bank arg) {
		theBank = arg;
	}
	
	public SavingsAccount getSavingsAccount() {
		
		if(otherAccount != null && otherAccount instanceof SavingsAccount) {  
			return (SavingsAccount)otherAccount; 
		} else {
			return null;
		}
	} 
	
	public String toString () {
		String output = "";
		int accountNr = thisAccountNumber;
		
		if(this instanceof SavingsAccount || this instanceof CurrentAccount) {
			
			if(this instanceof SavingsAccount) {
				output = "Savings Account ";
				accountNr +=1;
			}
			else if (this instanceof CurrentAccount) {
				output = "Current Account ";
			}
			
			output = output + balance + "\n";
			
				
		}
		
		
		else if (this instanceof Loan) {
			output = "Loan: " + getBalance() + "\n";
		}		
		
		for(int i = 0; i < transactions.size(); i++) {
			output = output + transactions.get(i) + "\n";
		}
		
		return output;
	}

}
