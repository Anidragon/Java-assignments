/*
 * @author ellis
 */

public class CheckingAccount extends BankAccount
{

	
	public final static double TRANSACTION_FEE = 1.50;
	public final static int FREE_TRANSACTIONS = 10;
	
	private int numTransactions;
	
	/**
	 * creates checking account with initial balance
	 * @param n name
	 * @param b balance
	 */
	public CheckingAccount(String n, String sa, String c, String st, double b, String z)
	{
		super(n,sa,c,st,b,z);
		numTransactions = 0;
	}
	
	
	/**
	 * recreate existing account
	 * 
	 */
	public CheckingAccount(String n, String sa, String c, String st, double b, String z, int an, int nt)
	{
		super(n,sa,c,st,b,z,an);
		numTransactions = nt;
	}
	
	public void withdraw(double amt)
	{
		numTransactions++;
		super.withdraw(amt);
		if(numTransactions > FREE_TRANSACTIONS)
			super.withdraw(TRANSACTION_FEE);
			
	}
	
	public void endOfMonthUpdate()
	{
		
		numTransactions = 0;
	}
	
	public int getNumTransactions()
	{
		
		return numTransactions;
		
	}
	
	

	
	
	

}
