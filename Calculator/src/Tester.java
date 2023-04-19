import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tester {

	
	public static int bigwords(ArrayList<String> lines) 
    {
       
        if(lines.get(0).equals("0"))
        {
            return 0;
        }
            int max = 0;
            int total = 0;
        
        for(int i = 1 ; i < lines.size() ; i++)
        {   
            String[] arr =  lines.get(i).split(" ");
            for(String x : arr)
            {
                if(x.length() > max)
                {
                    max = x.length();
                }
                
            }
            total += max;
            max = 0;
        }
        
        return total;
    }
	
	 public static String move(String start_location, String moves) 
	 {
	        ArrayList<String> letters = new ArrayList<String>();
	            Collections.addAll(letters, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
	        
	        int letPos = letters.indexOf(start_location.charAt(0) + "");
	        int numPos = Integer.parseInt(start_location.charAt(1) + "");
	        
	        for(int i = 0; i < moves.length() ; i++)
	        {
	            int move = Integer.parseInt(moves.charAt(i) + "");
	            
	            if(move == 1)
	            {
	               numPos++;
	            }
	            
	            else if(move == 2)
	            {
	                if(letPos + 1 <= 25)
	                {
	                    
	                    if((letPos) % 2 == 0)
	                    {
	                        numPos ++;
	                    }
	                    letPos++;
	                }
	            }
	            
	            
	            else if(move == 3)
	            {
	                if((letPos % 2 == 0) || numPos > 1)
	                {
	                    if(letPos < 25)
	                    {
	                        if(letPos % 2 == 0)
	                        {
	                            letPos++;
	                           
	                        }
	                        
	                        else
	                        {
	                            letPos++;
	                            numPos--;
	                            
	                        }
	                    }
	                }
	            }
	             else if(move == 4)
	            {
	                if(numPos > 1)
	                {
	                    numPos--;
	                }
	             }
	             else if(move == 5)
	            {
	                  if((letPos % 2 == 0) || numPos > 1)
	                {
	                    if(letPos > 0)
	                    {
	                        if(letPos % 2 == 0)
	                        {
	                            letPos--;
	                           
	                        }
	                        
	                        else
	                        {
	                            letPos--;
	                            numPos++;
	                            
	                        }
	                    }
	                }  
	             }   
	                 
	             else if(move == 6)
	            {
	                    if(letPos -1 >= 0)
	                {
	                    
	                    if((letPos) % 2 == 0)
	                    {
	                        numPos++;
	                    }
	                        letPos--;
	                }
	            }
	           
	        }
	            
	        
	        
	          String finalLet = letters.get(letPos);
	            int finalNum = numPos;
	            
	            return finalLet+finalNum;

	    }
	 
public static void main(String[] args)
{
   System.out.println(move("B2", "2243"));
	
}

}
