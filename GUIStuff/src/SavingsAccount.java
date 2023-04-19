/*
 * @author ellis
 */
public class SavingsAccount extends BankAccount
{
	public static final double INTEREST_RATE = 0.001;
	
	/**
	 * creates savings account with initial balance
	 * @param n name
	 * @param b balance
	 */
	public SavingsAccount(String n, String sa, String c, String st, double b, String z)
	{
		super(n,sa,c,st,b,z);
		
	}
	
	
	/**
	 * creates savings account with zero balance
	 * @param n name
	 */
	public SavingsAccount(String n, String sa, String c, String st, double b, String z, int an)
	{
		super(n,sa,c,st,b,z,an);
	}
	
	public void endOfMonthUpdate()
	{
		deposit(getBalance() * INTEREST_RATE);
		
	}
}
