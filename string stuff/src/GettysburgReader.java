import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class GettysburgReader {
	
	public static String findLongestWord(ArrayList<String> arr) {
		String maxWord = null;
		String Compare = null;
		int maxLength = 0;
		for(String word: arr) {
		    Compare = word;
		    if(maxLength < word.length()) {
		    	maxWord = word;
		    	maxLength = word.length();
		    }
		}
		return maxWord;
		}
	
	public static double findAverageWord(ArrayList<String> arr) {
		int total = 0;
		for(String i : arr) {
			total += i.length();
		}
		double average = total*1.0/arr.size();
		
		return average;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner fileIn = new Scanner(new File("C:\\Users\\aniak\\eclipse-workspace\\string stuff\\src\\GettysburgAddress.txt"));
		String text = fileIn.toString();
		ArrayList<String> storage = new ArrayList<String>();
		
		while(fileIn.hasNext())
		{
			String wordCompare = fileIn.next().toString();
			
			
			wordCompare = wordCompare.replace("," ,"");
			
			wordCompare = wordCompare.replace("." ,"");
			
			wordCompare = wordCompare.replace("-" ,"");
			if(wordCompare.contains(" ")) {
				int index = wordCompare.indexOf(' ');
				String string1 = wordCompare.substring(0, index);
				String string2 = wordCompare.substring(index + 1, wordCompare.length());
				storage.add(string1);
				storage.add(string2);
			}
			else {
				storage.add(wordCompare);
			}
			
			
		}
	
		System.out.println("The longest word is: " + findLongestWord(storage));
		System.out.println("on average the word length is: " + findAverageWord(storage));
	    System.out.println(storage);
		fileIn.close();
		
	}
		
		
}
