/*
 * @author ellis
 */

public abstract class BankAccount 
{
	
	private static int nextAccNum = 19753;
	
	//account holder info
	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	
	//balance for account
	private double balance;
	
	//account number
	private int acctNumber;
	
	
	
	/**
	 * creates account with balance initialized to b
	 * @param n name
	 * @param b balance
	 */
	public BankAccount(String name, String streetad, String city, String state, double balance, String zip)
	{
		if(balance < 0)
			throw new IllegalArgumentException("negative deposit");
		this.name = name;
		this.balance = balance;
		streetAddress = streetad;
		this.city = city;
		this.state = state;
		zipCode = zip;
		acctNumber = nextAccNum;
		nextAccNum += (int)(Math.random()*10)+1;
		
		
		
	}
	
	
	/**
	 * ONLY TO BE CALLED IF IMPORTING ALL ACCOUNTS
	 * creates account with balance initialized to b
	 * @param n name
	 * @param b balance
	 */
	public BankAccount(String n, String sa, String c, String st, double b, String z, int an)
	{
		if(b < 0)
			throw new IllegalArgumentException("negative deposit");
		name = n;
		balance = b;
		streetAddress = sa;
		city = c;
		state = st;
		zipCode = z;
		acctNumber = an;
		if(an > nextAccNum)
			nextAccNum = an + (int)(Math.random()*10)+1;
			
	}
	
	
	/**
	 * deposit amt into account
	 * @param amt amount to deposit
	 */
	public void deposit(double amt)
	{
		if(amt < 0)
			throw new IllegalArgumentException("negative deposit");
		balance = balance + amt;
	}
	
	
	
	
	/**
	 * withdraw amt from account
	 * @param amt amount to withdraw
	 */
	public void withdraw(double amt)
	{
		if(amt < 0 || amt > balance)
			throw new IllegalArgumentException("invalid withdraw");
		balance = balance - amt;
	}
	
	
	/**
	 * transfers money from this accout to other
	 * @param other destination account
	 * @param amt	amount to deposit
	 */
	public void transfer(BankAccount other, double amt)
	{
		if(this.name.equals(other.name))
		{
			this.withdraw(amt); //will appropriately throw exceptions
			other.deposit(amt);
		}
	}
	
	
	
	//end of month update
	public abstract void endOfMonthUpdate();
		
		
	
	//getName method that returns the name
	public String getName()
	{
		return name;
	}
	
	//returns the street address
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	
	//returns the city
	public String getCity()
	{
		return city;
	}
	
	//returns the state
	public String getState()
	{
		return state;
	}
	
	//returns zipCode
	public String getZipCode()
	{
		return zipCode;
	}
	
	//getBalance method that returns the balance
	public double getBalance()
	{
		return balance;
	}
	
	//returns the account number
	public int getAccountNumber()
	{
		return acctNumber;
	}
	
	//sets the street address
	public void setStreetAddress(String sa)
	{
		streetAddress = sa;
	}
	
	
	//sets the city
	public void setCity(String c)
	{
		city = c;
	}
	
	//sets the state
	public void setState(String s)
	{
		state = s;
	}
	
	//sets zipCode
	public void setZipCode(String z)
	{
		zipCode = z;
	}
	
	
	
		


	
	
}
