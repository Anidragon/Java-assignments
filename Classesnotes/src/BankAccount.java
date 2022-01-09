//	Create a BankAccount class with the following:
//
//		Fields: name, balance, accountNumber
//
//		Constructors:
//
//		           -one which takes two arguments.  It initializes name and accountNumber through the arguments and initialized the balance to 0.
//
//		           - a second which takes three arguments.  It initializes all three fields through the arguments
//
//		Methods:
//
//		-deposit -- takes an argument for the amount to deposit and imcrements balance appropriately
//
//		-withdraw -- takes a parameter for the amount to withdraw and decrements balance appropriately
//
//		-getBalance-- takes no arguments and returns the balance
//
//		toString -- takes no arguments and returns the value of each field
public class BankAccount {

	private String name;
	private double balance;
	private int    accountNumber;
	
	
    public BankAccount(String nm, int accNum){
    	
    	name = nm;
    	balance = 0;
    	accountNumber = accNum;
    }
    
	
    public BankAccount(String nm, int accNum, double bal){
    	
    	name = nm;
    	balance = bal;
    	accountNumber = accNum;
    	
    }

    public void deposit(double depositAmmount){
    	
    	balance += depositAmmount;
    }
    
    public void withdraw(double withdrawAmmount){
    	
    	balance -= withdrawAmmount;
    }
    
    public double getBalance(){
    	
    	return balance;
    }
    
 
	public String toString() {
		
		return "name: " + name + "\n" + "balance: " + balance + "\n" + "accountNumber: " + accountNumber;
		
	}
	

}
