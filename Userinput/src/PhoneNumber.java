import java.util.Scanner;

public class PhoneNumber {
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name as 'FIRST NAME' 'LAST NAME'"
				+ "(the space between names should be the only space typed)");
		String name = scanner.nextLine();
		
		System.out.println("Enter your phone number as XXXXXXXXXX");
		String phoneNumber = scanner.nextLine();		
		
		
        System.out.println("your unformatted Phone number and name is: " + name +" "+ phoneNumber + "\n");
        
        //formatted number
        String numberCut = phoneNumber.substring(0, 3);
        String numberCutFinal = "("+numberCut+") ";
        String numberCut2 = phoneNumber.substring(3, 6);
        String numberCutFinal2 = numberCut2 + "-";
        String numberCut3 = phoneNumber.substring(6, 10);
        System.out.println("your formatted number is: " + numberCutFinal + numberCutFinal2 + numberCut3 + "\n");
        
        String formattedNumber = ( numberCutFinal + numberCutFinal2 + numberCut3);
		//formatted name
        int cutIndex = name.indexOf(" ");
        String nameCut = name.substring(0, cutIndex);
        String nameCut2 = name.substring(cutIndex + 1);
        System.out.println("Your formatted name is: "+ nameCut2 + ", " + nameCut + "\n");
        
        String formattedName = (nameCut2 + ", " + nameCut);
        
		//together
        System.out.println("your fully formatted name and number is: ");
        System.out.printf("%-30s",formattedName + "\t" + formattedNumber );
		
	}
	

}
