
public class MethodTester 
{
public static char indexAt(String myString)

{
	char ind5 = myString.charAt(5);
	return ind5;
}

public static int len (String mystring) 
{
	int charnum = mystring.length();
	return charnum;
}
public static String someMethod(String mystring) 
{
	
	String somestr = mystring.substring(4, 8);
	return somestr;
	
}
public static String oReplace (String mystring) 
{
	
	String oToStar = mystring.replaceAll("o", "*");
	return oToStar;
	
}
public static int indexM (String mystring) 
{
	
	int mIndex = mystring.indexOf("m");
	return mIndex;
	
}
	public static void main(String[] args) 
	{
		
		String myString = "Run some methods on this jawn";
		
		
		//1. write  code which will return the character at index 5 and 
		//  store it in a variable.  display the value of the variable in the console
		char index = indexAt(myString);
		System.out.println("the Sixth character is: " + index);
		//2. write code which will return the length of the string and store it in a 
		//   variable.   Display the content of the variable in the console.
		int length = len(myString);
		System.out.println("the length of myString is: "+ length);
		//3. write code which will return the word 'some' and store it in a variable 
		//     you must use a method on myString to generate the word, you may not type 'some'
		String someStr = someMethod(myString);
		System.out.println("the string between indexes 4 and 7 (inclusive) is: "+ someStr);
		//4. write code which will display the string in myString with all char 'o' 
		//      replaced with '*'
		String otostar = oReplace(myString);
		System.out.println("the string with censored o's: "+ otostar);
		//write a line of code which will return and print the index of the letter m in the 
		//      given string, myString
		int indexAtM = indexM(myString);
		System.out.println("the index of the first m in this string is: "+ indexAtM);
	}

}
