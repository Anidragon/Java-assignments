
public class CrackMe {
	
	private String pinNum;
	
	public CrackMe() {
		
		pinNum = "" + (int)(Math.random()*900 + 100);
		
		}
	
	
public boolean checkFirstDigit(String pinGuess) {
	
	char firstDigit = pinGuess.charAt(0);
	
	char correctFirstDigit = pinNum.charAt(0);
	
	if (firstDigit == correctFirstDigit) {
		
		return true;
		
	}
	else {
		
		return false;}
		
	}
	
	public boolean checkSecondDigit(String pinGuess) {
		
		char SecondDigit = pinGuess.charAt(1);
		
		char correctSecondDigit = pinNum.charAt(1);
		
		if (SecondDigit == correctSecondDigit) {
			
			return true;
			
		}
		else {
			
			return false;}
			
		}
		public boolean checkThirdDigit(String pinGuess) {
			
			char thirdDigit = pinGuess.charAt(2);
			
			char correctThirdDigit = pinNum.charAt(2);
			
			if (thirdDigit == correctThirdDigit) {
				
				return true;
				
			}
			else {
				
				return false;
				
			}
		}

			public String toString() {
				return "pinNum is" + pinNum;
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//-----------------------------
	}


