import java.util.Scanner;

public class CrackMeMain {

	public static void main(String[] args) {
		
		CrackMe Cracker = new CrackMe();
		Scanner scanner = new Scanner(System.in);
		//System.out.println(Cracker.toString());
		int counter = 0;
		char unk1 = '_';
		char unk2 = '_';
		char unk3 = '_';
		while (counter < 10) {
			int guesses = 10 - 1 - counter;
			counter +=1;
		
		System.out.println("guess the three digit PIN");
		
		
		if(scanner.hasNextInt()) {
			int guess = scanner.nextInt();
			if(guess >= 100 && guess <= 999) {
			String strguess = guess + "";	
			scanner.nextLine();
				if(Cracker.checkFirstDigit(strguess) == true) {
					unk1 = strguess.charAt(0);
				}
			    if(Cracker.checkSecondDigit(strguess) == true) {
					unk2 = strguess.charAt(1);
				}
			    if(Cracker.checkThirdDigit(strguess) == true) {
					unk3 = strguess.charAt(2);
			    }
			    if(Cracker.checkThirdDigit(strguess) == true && Cracker.checkSecondDigit(strguess) == true 
						&& Cracker.checkFirstDigit(strguess) == true) {
			    	break;
			    }
			
			    System.out.println("you guessed: " +unk1+ " "+ unk2+ " " +unk3+ " you have" + " "+guesses+ " "+ "guesses left" );
			    }
			}
		else {
			scanner.nextLine();
			System.out.println("you did not enter a three digit number value try again " + guesses + " guesses left");	
		}
		
			
		}
		if (counter == 10){
		System.out.println("you couldn't guess the PIN!! try again next time! the PIN was: " );
	}
		else{
			System.out.println("you got the PIN in " + counter + " tries! the PIN was: " +unk1+ " "+ unk2+ " " +unk3 );
		}
		}
		}
		
		
		
		
		
		
		
		
		
//		boolean crackOrNot;
//		
//		if (crackOrNot == true) {
//			
//		}
//		+ guesses +

	


