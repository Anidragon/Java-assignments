
public class DiceCounter {
	
	public static void main(String[] args) {
		
		int currentRoll;
		int ones = 0;
		int twos = 0;
		int threes = 0;
		int fours = 0;
		int fives = 0;
		int sixes = 0;
		
		Dice dice = new Dice();
		
		int numRolls = dice.getNumRolls();
		System.out.print("Rolls: ");
		
		while (numRolls < 10) {
			currentRoll = dice.roll();
			numRolls = dice.getNumRolls();
			System.out.print(currentRoll + " ");
			if(currentRoll == 1) {
			ones += 1;
		}
			else if(currentRoll == 2) {
				twos += 1;
		}
			else if(currentRoll == 3) {
				threes += 1;
		}
			else if(currentRoll == 4) {
				fours += 1;
		}
			else if(currentRoll == 5) {
				fives += 1;
		}
			else {
				sixes += 1;
		}
		
		}
		
		System.out.println("\n");
		System.out.println("number of ones rolled: " + ones );
		System.out.println("number of twos rolled: " + twos );
		System.out.println("number of threes rolled: " + threes );
		System.out.println("number of fours rolled: " + fours );
		System.out.println("number of fives rolled: " + fives );
		System.out.println("number of sixes rolled: " + sixes );
	}	
}
			
		
	
	

