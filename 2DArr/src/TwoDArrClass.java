import java.util.Scanner;

public class TwoDArrClass {

public static int[] randArrMaker(){
	int[] arr = new int[(int)(Math.random()*51 + 50)];
	
	
	for(int i = 0; i < arr.length; i++) 
	{
		
		arr[i] = (int)(Math.random()*99 + 1);
		
		}
	
	return arr;
}

public static int[][] twoDArrMaker(int[] arr){
	int rows;
	if(arr.length % 7 > 0) {
	rows = (arr.length/7) + 1;
	}
	else {
		rows = (arr.length/7);
	}

	
	int[][] finalArr = new int[rows][7];
	int count = 0;
	for(int i = 0 ; i < rows ; i++) {
		 
			for(int j = 0 ; j < 7 ; j++) {
			if(count < arr.length) {
				finalArr[i][j] = arr[count];
				count++;
			}
		}
	}
	
	return finalArr;
}

public static void main(String[] args) {
	int [] arr = randArrMaker();
	System.out.print("The original Array was: ");
	for (int i = 0 ; i < arr.length - 1 ; i ++ ) {
	System.out.print(arr[i] + ", ");
	}
	int[][] twoDArr = twoDArrMaker(arr); 
	System.out.println("\n");
    System.out.println("The 2D Array is:");
	for(int[] i : twoDArr) {
		System.out.println("\n");
		for(int j : i) {
	    	System.out.print(j + ", ");
	    }
	    }
	
	System.out.println("\n");
	Scanner scanner = new Scanner(System.in);
	System.out.println("what value would you like to find?");
	int find = scanner.nextInt();
	scanner.nextLine();
	int count2 = -1;
	boolean bool = true;
	for(int[] i : twoDArr) {
       count2++;
		for(int j = 0; j < 7; j++) {
			if(i[j] == find) {
				System.out.println("The Row index where " + find + " was found is " + count2);
				System.out.println("The Coulumn index where " + find + " was found is " + j);
				break;
			}
			if(i[j] == find) 
			{
				bool = false;
				break;
				}
			else {
				bool = true;
			}
		}
	}
	if(bool) {
		System.out.println("value not found");
	}
}
  
}
