
public class Dice 
{
	private int numRolls;
	private int sides;
	public Dice()
	{
		numRolls = 0;
	}
	
	public int roll(int sides)
	{
		numRolls = numRolls + 1;
		return (int)(Math.random()*sides + 1);
		
	}
	
	public int getNumRolls()
	{
		return numRolls;
	}
	
	public void reset()
	{
		numRolls = 0;
	}

}
