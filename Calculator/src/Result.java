import java.util.ArrayList;
import java.util.HashSet;


	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;


	class Result {

	    /*
	     * Complete the 'countUniqueValues' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts INTEGER fibNumber as parameter.
	     */

	    public static int countUniqueValues(int fibNumber)
	     
	    {
	        ArrayList<ArrayList<Long>> triangle = new ArrayList<ArrayList<Long>>();
	        ArrayList<Long> usedNums = new ArrayList<Long>();
	        Map<Long, Integer> freq = new HashMap<>();
	        int rows = findIndex(fibNumber);
	        System.out.println(rows);
	        for(int i = 0; i <= rows; i++)
	        {
	            triangle.add(new ArrayList<Long>());
	        }
	        
	        generatePascal(rows, triangle);
	        System.out.println(triangle);
	        remover(triangle, rows);
	        System.out.println(triangle);
	        for(ArrayList<Long> X: triangle)
	        {
	            for(Long num: X)
	            {
	                usedNums.add(num);
	            }
	        }
	        System.out.println(usedNums);
	        
	        for(Long num : usedNums)
	        {
	          if(freq.containsKey(num))
	          freq.put(num, freq.get(num) + 1);
	          
	          else
	          freq.put(num, 1);  
	        }
	        System.out.println(freq);
	        int occuredOnceSize = 0;
	        
	        for(Integer frequency : freq.values())
	        {
	            if(frequency == 1)
	            occuredOnceSize++;
	            
	        }
	        
	        return occuredOnceSize;
	        
	    }
	        public static ArrayList<ArrayList<Long>> generatePascal(int n, ArrayList<ArrayList<Long>> arr)
	    {
	    
	        for(int line = 1; line <= n; line++)
	        {
	             
	        long C = 1;
	        for(long i = 1; i <= line; i++)
	        {
	            arr.get(line).add(C);
	            C = C * (line - i) / i;
	        }
	        
	        }
	        arr.remove(0);
	        return arr;
	    }
	    
	    public static int findIndex(int n)
	    {
	      float fibo = 2.078087F * (float) Math.log(n) + 1.672276F;
	   
	      // returning rounded off value of index
	      return Math.round(fibo);
	    }
	    
	    public static void remover(ArrayList<ArrayList<Long>> triangle, int rows)
	    {
	       int removeCount = rows - 1;
	  int tempCount = removeCount;
	  for(int i = triangle.size() - 1; i > 0; i--)
	  {
	      tempCount = removeCount;
	      for (int j = triangle.get(i).size() - 1; j > 0; j--)
	      {
	         tempCount--;
	         triangle.get(i).remove(j);
	         if(tempCount <= 0)
	             break;
	      }
	      removeCount -= 2;
	      if(removeCount <= 0)
	          break;
	  }  
	        
	    }
	   
	}
	
	public static void main(String[] args) 
	{
		
		
	}
	
	}
