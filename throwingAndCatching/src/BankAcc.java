
public class BankAcc {

	private double balance;
	
	private String name;
	
	public BankAcc(double balance, String name)
	{
		this.balance = balance;
		this.name = name;
	}
	
	public void deposit(double deposit)
	{
		if(deposit <= 0)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			balance += deposit;
		}
	}
	
	public void withdraw(double withdraw)
	{
		if(withdraw <= 0 || withdraw > balance)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			balance -= withdraw;
		}
	}
		
		public double getBalance()
		{
		return balance;
	}
	
}
