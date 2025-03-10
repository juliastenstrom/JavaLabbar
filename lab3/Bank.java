package lab3;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Bank {
	
	public final String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	private ArrayList <Loan> theLoans= new ArrayList<Loan>();
	
	
	public Bank(String arg) {	
		NAME = arg;
		Account.setBank(this);
	}
	
	
	public CurrentAccount searchAccount(String arg) {
		   CurrentAccount temp = null;
		   for (int i=0; i < theAccounts.size(); i++) {
		    if (theAccounts.get(i).getCustomer().equals(arg) && theAccounts.get(i) instanceof CurrentAccount) temp = (CurrentAccount) theAccounts.get(i);
		   }
		   return temp;
		 }
	
	
	public String createAccount(String arg1, double arg2) {
		if(searchAccount(arg1) != null) {
			return "Account(s) already exists for: " + arg1;
		}
			theAccounts.add(new CurrentAccount(arg1, arg2));
			return "Current account created for: " + arg1;
			
		
		}
	
	public String createAccount(String arg1, double arg2, double arg3) {
		   if (searchAccount(arg1)==null) {
		    CurrentAccount temp = new CurrentAccount(arg1, arg2, arg3);
		    theAccounts.add(temp); 
		    theAccounts.add(temp.otherAccount);
		    return "Current and savings accounts created";
		   }
		   else return "Accounts already exist";
		 }
	
	public void currentToSavings(String arg1, double arg2) {
		try{		
			CurrentAccount k = searchAccount(arg1); 
			k.savings(arg2); 
		}catch(Exception e) {
			return;
		}
	}

	
	public String checkPerson(String arg) {
		String result = arg + "\n";
		CurrentAccount m = searchAccount(arg);

		if(m != null) {
			result = result + m;
			if(m.otherAccount != null) result = result + m.otherAccount;
			for (int i = 0; i < theLoans.size(); i++) {
				if(theLoans.get(i).getCustomer().equals(arg)) {
					result = result + theLoans.get(i);
				}
			}
			return result;
		}
		
		else return "Person does not exist";
	}
	
	
	public void transfer(String arg1, String arg2, double arg3) {
		CurrentAccount ac1 = searchAccount(arg1);
		CurrentAccount ac2 = searchAccount(arg2);
		
		if(ac1 != null && ac2 != null) {
			ac1.send(arg3, ac2);
		}
	}
	
	public void getLoan(CurrentAccount arg) {
		 Loan loan = new Loan(arg);
		 theLoans.add(loan);
	}
	
	//förstår inte helt instruktionerna
	public void cashPayment(String arg1, double arg2) {
		for(int i = 0; i < theLoans.size(); i++) {
			Loan loan = theLoans.get(i);
			if(loan.getCustomer() == arg1) {
				double result = loan.payOff(arg2);
				if(result > 0) {
					arg2 = result;
					theLoans.remove(i);
					i--;
				} else {
					return;
				}
			}
		}
		
		CurrentAccount acc = searchAccount(arg1);
		acc.receive("Cash pyament", arg2);
	}
	
	public void computeAnnualChange() {
		for(int i = 0; i < theAccounts.size(); i++) {
			theAccounts.get(i).annualChange();
		}
		
		for(int i = 0; i < theLoans.size(); i++) {
			theLoans.get(i).annualChange();
		}
	}
	
	
	public String toString() {
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		int nrOfAcc = theAccounts.size();
		for(int i = 0; i < theAccounts.size(); i++) {
			sum1 = sum1 + theAccounts.get(i).getBalance();
			
			if(theAccounts.get(i).getSavingsAccount() != null) {
				nrOfAcc++;
				sum2 = sum2 + theAccounts.get(i).getSavingsAccount().getBalance();
			}
		}
		
		int l = 0;
		
		for(int i = 0; i < theLoans.size(); i++) {
			sum3 = theLoans.get(i).getBalance();
			l++;
		}
		
		String result = "Bank: " + NAME + "\n" + "Accounts: " + nrOfAcc + "\n" + "Loans: " + l + "\n";

		result = result + "Money in current/savings accounts and loan: " + sum1 + " / " + sum2 + " / " + sum3; 
		return result;
	}
}
	
 