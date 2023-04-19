import java.util.Scanner;

public class BankAccMain {

	public static void main(String[] args) {
		
		
	Scanner scanner = new Scanner(System.in);	
	BankAcc acc = new BankAcc(0, "Ani:]");
	int optionnum = -1;
		while(optionnum != 0)
		{
			System.out.println("welcome to the bank, type 1 to deposit, 2 to withdraw, 3 to get balance, or 0 to terminate ");
			boolean mybool = true;
			try
			{
				
				optionnum = scanner.nextInt();
				
				scanner.nextLine();
				
				mybool = false;
				if(optionnum != 0 && optionnum != 1 && optionnum != 2 && optionnum != 3) 
				{
					throw new Exception();
				}
			}
			
			catch(Exception e)
			{
			System.out.println("did not give valid input, try again");
			if(mybool)
			{
			scanner.nextLine();
			}
			optionnum = 4;
			}
			
			 switch (optionnum) {
	            case 1:  
	            	double deposit = 0;
	            	System.out.print("how much would you like to deposit?");
	            	try {
	            	    deposit = scanner.nextDouble();
	            		scanner.nextLine();
	            	}
	            	catch(Exception e)
	            	{
	            		System.out.println("did not give valid input");
	            		scanner.nextLine();
	        			break;
	            	}
	                    try { 
	            	    	acc.deposit(deposit);
	            	    	}
	            	    catch(IllegalArgumentException e)
	            	    {
	            	    	System.out.println("your number was not greater than 0");
	            	    	break;
	            	    }
	                    System.out.println("your transaction was made");
	                     break;
	            case 2: 
	            double withdraw = 0;
	            System.out.print("how much would you like to withdraw?");
	            try {
        		withdraw = scanner.nextDouble();
        		scanner.nextLine();
	            }
	            
	            catch(Exception e)
	            {
	            	System.out.println("did not give valid input");
            		scanner.nextLine();
        			break;	
	            }
                try { 
        	    	acc.withdraw(withdraw);
        	    	}
        	    catch(IllegalArgumentException e)
        	    {
        	    	System.out.println("your number was not greater than 0, or too much to withdraw from your account");
        	    	break;
        	    }
                System.out.println("your transaction was made");
                	break;
                	
	            case 3:
	            	System.out.print("Your balance is: " + acc.getBalance() + '\n');
	            	break;
	                     
	            case 4:
	                     break;
	            default:
	            	System.out.println("Thanks have a nice day");
                    break;
	            	
	         
			
		}
		
			
       

	}

}
	
}
