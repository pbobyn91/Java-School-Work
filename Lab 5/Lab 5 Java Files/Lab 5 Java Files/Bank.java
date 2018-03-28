package lab5;

public class Bank {

	// TODO Declare instance variables
	
	// TODO Declare class variables
	
	public Bank() {
		// TODO implement default Bank constructor
	}
	
	public Bank(String bankName, int bankSize) {
		// TODO implement overloaded Bank constructor
	}
	
	public void addBankAccount() {
		
		// TODO implement addition of Bank.addBankAccount()
		
	}
	
	public void displayAccount() {
		
		// TODO implement Bank.displayAccount() error handling
		
		System.out.println(accounts[findAccount()]);
		
	}
	
	public void updateAccount() {
		
		// TODO implement Bank.updateAccount() error handling
		accounts[findAccount()].calculateAndUpdateBalance();
	}
	
	public void monthlyUpdate() {
		
		// TODO implement Bank.monthlyUpdate()
	}
	
	public int findAccount() {
		
		// TODO implement Bank.findAccount()
		
		return -1;
	}
	
	public static int searchAccounts(int accToFind) {
		
		// TODO implement Bank.searchAccounts(int accToFind)
		
		return -1;
		
	}
	
}
