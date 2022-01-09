
public class Counterclass {

	//fields
	
	private int count;
	
	private int countBy;
	
	//constructors
	
	public Counterclass(int cb) {
		
		count = 0;
	    countBy = cb;
		
		
	}
	
	//methods
	public void click() 
	{
		
		count += countBy;
		
		
		
	}
	
	public int getCount() {
		
		return count;
	}
	public void rest(){
	count = 0;
		
	}
}
