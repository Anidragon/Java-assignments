
public class Calculator 

{
	
	public static void main(String[] args)
	{
		
		
		//String - anything in between "   ", a series of characters , "35" 
				//"""  """ - to make a multi line string
		
		//char - a single character 'v', '@'
				// + - concatenation
		
		//int - a number (no decimals), 35, 67, 23, 4
		
		// double - a number that has decimals 35.0, 78.9
				// + - addition
				// - - subtraction
				// * - multiplication
				// / - division
				// % - mod division (returns the remainder)
		
		// boolean - a true or false, true, false
		
		//System.out.print("d");
		
		
// variables: containers
		
		// defining a variable: data type > variable > = > value
		
		int num = 45;
		String str = "hello";
		char chr = 'H';
		double decimal = 45;
		boolean bool = true;
		
// ++, -- : increase and decrease num by one
		
	
//		num--;
//		
//		--num;
	
			//logic statements dont end with semicolons
		// == : return true if equal, return false if not
		// != : return true if not equal, return false if equal
		// < : return true if less than, return false if greater than or equal to
		// > : return true if greater than, return false if less than or equal to
		// <= : return true if less than or equal to, return false if greater than
		// >= : return true if greater than or equal to, return false if less than
//		if(num < num)
//		{
//			System.out.println(num);
//		}
//		
//		else
//		{
//			System.out.println("the if statement did not print");
//		}
//		
		//while loops
		//for loops
		
		
	
//for loops and while loops above	
		
		String[] array = new String[3];
		String[][] TicTacToeBoard = new String[3][3];
		// | 0 |-----| 0 |-----| 0 |
		
		// {
		//    {		|	|	}                              
		//	  {		|	|	} 
		//	  {		|	|	} 
		//	  
		//
		//						}
		
		
		
		
		TicTacToeBoard[0][0] = "O";
		TicTacToeBoard[1][0] = "X";
		TicTacToeBoard[2][2] = "O";
		TicTacToeBoard[1][1] = "X";
		TicTacToeBoard[2][0] = "O";
		
		for(int i = 0; i < TicTacToeBoard.length; i++)
		{
			System.out.println("\n");
			
			for(int j = 0; j < TicTacToeBoard[i].length; j++)
			{
				if(TicTacToeBoard[i][j] == null)
				{
				    System.out.print(" [] ");
				}
			
				else
				{
					System.out.print(" " + TicTacToeBoard[i][j] + " ");
				}
			}
		}
		
	
		}
		
	}


