
public class DiceTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dice D1 = new Dice();
		
		Dice D2 = new Dice();
		
		double rollcalc = Math.random() * 100;
		
		int rolls  = (int) rollcalc;
		
		int rollupper = 0;
		
		while (rollupper != rolls) {
			
			rollupper += 1;
			int value = D1.roll();
			
			System.out.println(" when Dice 1 was rolled "+rollupper+" times "+ value+" was rolled");
			//print staement to display the rolled value every time
			
		};
		

	
		double rollcalc2 = Math.random() * 100;
		
		int rolls2  = (int) rollcalc2;
		
		int rollupper2 = 0;
		
		while (rollupper2 != rolls2) {
			
			rollupper2 += 1;
			int value = D2.roll();
			
			System.out.println("when Dice 2 was rolled "+rollupper2+" times "+ value+" was rolled");
			//print staement to display the rolled value every time
			
		};
		 
		System.out.println(" ");
        System.out.println("Times rolled each dice:");
		System.out.println("Dice 1 was rolled "+D1.getNumRolls()+" times");
        //final print statement to display the number of times D1 was rolled
		System.out.println(" ");
		System.out.println("Dice 2 was rolled "+D2.getNumRolls()+" times");
        //final print statement to display the number of times D2 was rolled
		
	    D1.reset();
	    //resetting D1 only
		System.out.println(" ");
        System.out.println(" ***************RESET D1************** ");
		System.out.println("Dice 1 was rolled "+D1.getNumRolls()+" times");
        //final print statement to display the number of times D1 was rolled
		System.out.println(" ");
		System.out.println("Dice 2 was rolled "+D2.getNumRolls()+" times");
        //final print statement to display the number of times D2 was rolled
	    
	}

}
