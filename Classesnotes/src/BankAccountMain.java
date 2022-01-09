
public class BankAccountMain {

	
	/*
	 * Create a bank account in the name of Peyton Manning with an account number
	 * of 10 ($0 balance using the constructor which does not require an argument
	 * for balance). Create another bank account in the name of Jose Canseco with a
	 * $300 balance and an account number of 21. On each bank account make at least
	 * 3 withdraws and 3 deposits. You should check the balance after each. run the
	 * toString method at least once on each account. In order to receive full
	 * credit you must run every method and verify the result by printing to the
	 * screen.
	 */ 


	
	
	public static void main(String[] args) {
		
		BankAccount account1 = new BankAccount("Peyton Manning", 10);
		
		BankAccount account2 = new BankAccount("Jose Canseco", 21, 300.00);
		
		account1.deposit(1900.78);
		System.out.println("the balance of account1 after transaction 1 is: " + account1.getBalance());
		
		account2.deposit(5000.90);
		System.out.println("the balance of account2 after transaction 1 is: " + account2.getBalance());
		
		account1.withdraw(100000);
		System.out.println("the balance of account1 after transaction 2 is: " + account1.getBalance());
		
		account2.withdraw(150000);
		System.out.println("the balance of account2 after transaction 2 is: " + account2.getBalance());
		
		account1.deposit(647368);
		System.out.println("the balance of account1 after transaction 3 is: " + account1.getBalance());
		
		account2.deposit(7893.98);
		System.out.println("the balance of account2 after transaction 3 is: " + account2.getBalance());
		
		account1.withdraw(94025);
		System.out.println("the balance of account1 after transaction 4 is: " + account1.getBalance());
		
		account2.withdraw(93526.1);
		System.out.println("the balance of account2 after transaction 4 is: " + account2.getBalance());
		
		account1.deposit(5467778.34);
		System.out.println("the balance of account1 after transaction 5 is: " + account1.getBalance());
		
		account2.deposit(647583);
		System.out.println("the balance of account2 after transaction 5 is: " + account2.getBalance());
		
		account1.withdraw(67485);
		System.out.println("the balance of account1 after transaction 6 is: " + account1.getBalance());
		
		account2.withdraw(2356478.89);
		System.out.println("the balance of account2 after transaction 6 is: " + account2.getBalance());
		
		String acc1Fields = account1.toString();
		System.out.println("\t"+"The final information for account1 is: " + "\n" + acc1Fields);
		
		String acc2Fields = account2.toString();
		System.out.println("\t"+"The final information for account2 is: " + "\n" + acc2Fields);
		

	}

}
