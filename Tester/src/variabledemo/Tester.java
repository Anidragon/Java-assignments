package variabledemo;

import java.util.ArrayList;

public class Tester {
    
	
	 public static String fibCypher(char option, int num1, int num2, char key, String msg) 
	    {
	 if(option == 'E')
	           {
	            
	                 
	             
	             String returner = "";
	             long int1 = num1;
	             long corrector;
	             long other;
	             long int2 = num2;
	             int ascii = (int)key;
	             int ascii2;
	             long holder;
	             int msglength = msg.length();
	             
	             for(int i = 0 ; i < msglength ; i++)
	             {
	                 
	                 if(i%2 == 0)
	                 {
	                    holder = ascii + int1; 
	                      if(holder > 122)
	                    {
	                        corrector = holder - 122;
	                        
	                        corrector = corrector % 26;
	                        if(corrector == 0)
	                        {
	                            holder = 122;
	                        }
	                        
	                        else
	                        {
	                        holder = 97 + (corrector - 1);
	                        }
	                      
	                    }
	                    
	                 }
	                 else
	                 {
	                    holder = ascii - int1; 
	                    if(holder < 97)
	                    {
	                        corrector = 97 - holder;
	                        
	                        corrector = corrector % 26;
	                        
	                        if(corrector == 0)
	                        {
	                            holder = 97;
	                        }
	                        
	                        else
	                        {
	                            holder = 122 - (corrector - 1 );
	                        }
	                        
	                    }
	                    
	                 }
	                ascii2 = (int)msg.charAt(i);
	                
	                returner = returner.concat(String.valueOf(ascii2 + 3 * holder)).concat(" ");
	                other = int1;
	                int1 = int2;
	                int2 = other + int1; 
	             }
	             
	             String result = returner.substring(0,(returner.length()-1));
	             
	             return result;    
	           } 
	           
	           
	           else
	           {
	             String returner = "";
	             long int1 = num1;
	             long corrector;
	             long other;
	             long int2 = num2;
	             int ascii = (int)key;
	             long holder;
	              
	              String [] code = msg.split(" ");
	              int msglength = code.length;
	               
	          for(int i = 0 ; i < msglength ; i++)
	             {
	                 
	                 if(i%2 == 0)
	                 {
	                    holder = ascii + int1; 
	                      if(holder > 122)
	                    {
	                        corrector = holder - 122;
	                        
	                        corrector = corrector % 26;
	                        
	                        holder = 97 + (corrector - 1);
	                        if(holder == 96)
	                        {
	                            holder = 122;
	                        }
	                      
	                    }
	                    
	                 }
	                 else
	                 {
	                    holder = ascii - int1; 
	                    if(holder < 97)
	                    {
	                        corrector = 97 - holder;
	                        
	                        corrector = corrector % 26;
	                        
	                        
	                        holder = 122 - (corrector - 1 );
	                        if(holder == 123)
	                        {
	                            holder = 97;
	                        }
	                        
	                        
	                    }
	                    
	                 }
	                
	                returner += "" + (char)((int)(Integer.parseInt(code[i]) - (3*holder)));
	                
	                
	                other = int1;
	                int1 = int2;
	                int2 = other + int1; 
	             }
	              
	              
	              return returner;
	              
	                 
	           }
	       



	        }





	    
		
	
public static void main(String[] args) {
     
	System.out.println(fibCypher('D', 0, 1, 's', ""));
	
	
	
}
}

