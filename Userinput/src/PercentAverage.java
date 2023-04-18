import java.util.Scanner;

public class PercentAverage {
	
	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter what course you would like to take: ");
		String courseName = scanner.nextLine();
		System.out.println("Current course: "+ courseName);
		
		System.out.println("Enter the name of your first assesment: ");
		String assessName = scanner.nextLine();
		System.out.println("the name of your first assesment is: " + assessName);
		System.out.println("Enter your score on the first assesment(as a decimal): ");
		double score1 = scanner.nextDouble();
		//eraser:
		scanner.nextLine();
		System.out.println("score on "+ assessName + " for " + courseName + " is: " + score1 );
		
		System.out.println("Enter the name of your second assesment: ");
		String assessName2 = scanner.nextLine();
		System.out.println("the name of your first assesment is: " + assessName2);
		System.out.println("Enter your score on the second assesment: ");
		double score2 = scanner.nextDouble();
		//eraser:
		scanner.nextLine();
		System.out.println("score on "+ assessName2 + " for " + courseName + " is: " + score2 );
		
		System.out.println("Enter the name of your final assesment: ");
		String assessName3 = scanner.nextLine();
		System.out.println("the name of your first assesment is: " + assessName);
		System.out.println("Enter your score on the final assesment: ");
		double score3 = scanner.nextDouble();
		//eraser:
		scanner.nextLine();
		System.out.println("score on "+ assessName3 + " for " + courseName + " is: " + score3 );
		
	
		double combined = score1 + score2 + score3;
		
		long average = Math.round(combined/3);
		
		System.out.println("your average score to the nearest whole number in " + courseName + " is: " + average);
	}
	

	
	
	

}
