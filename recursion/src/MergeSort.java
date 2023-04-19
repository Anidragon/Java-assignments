import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args)
	{
		int[] start = new int[100];
		for(int i = 0; i < start.length; i++)
		{
			start[i] = (int)(Math.random()*20 + 1);
		}
		int[] sorted = Arrays.copyOf(start,start.length);
		Arrays.sort(sorted);
		mergesort(start);
		if(Arrays.equals(start, sorted))
			System.out.print("correctly sorted");
		else
			System.out.print("not properly sorted");
	}
	
	/*
	 * implement the mergesort method.  It should be a recursive
	 * implementation of the mergesort algorithm we spoke about
	 * in class.  If you run this main method it will tell you 
	 * if your algorithm properly sorted the array.  You do not 
	 * need to add any code to the main method.
	 */
	
	public static void mergesort(int[] arr)
	{
		int len = arr.length;
		//this if statement ends the method if the array has a length of 1
	    if (len < 2) {
	        return;
	    }
	    //splits the passed array into two
	    int midIndex = len / 2;
	    int[] temp1 = new int[midIndex];
	    int[] temp2 = new int[len - midIndex];
        //both these for loops fill the temp arrays with the proper values 
	    for (int i = 0; i < midIndex; i++) {
	        temp1[i] = arr[i];
	    }
	    for (int i = midIndex; i < len; i++) {
	        temp2[i - midIndex] = arr[i];
	    }
	    mergesort(temp1);
	    mergesort(temp2);
        //uses the combine helper method to recombine the sorted arrays
	    combine(arr, temp1, temp2, midIndex, len - midIndex);
		
	}
	
	public static void combine(int[] arr, int[] temp1, int[] temp2, int leastIndex, int mostIndex) {
		//tracks the original arrays index, as well as the two temp arrays' indices
			    int temp2Tracker = 0; 
			    int temp1Tracker = 0;
			    int origTracker = 0;
			  //this while loop runs as long as both arrays have numbers in them
			    while (temp1Tracker < leastIndex && temp2Tracker < mostIndex) {
			    	//if a number from the first temp array is less or equal, add it next to the original array
			        if (temp1[temp1Tracker] <= temp2[temp2Tracker]) {
			            arr[origTracker] = temp1[temp1Tracker];
			            temp1Tracker++;
			            origTracker++;
			        }
			      //otherwise, add the number from the other temp array
			        else {
			            arr[origTracker] = temp2[temp2Tracker];
			            temp2Tracker++;
			            origTracker++;
			        }
			    }
			    //these while loops will put the rest of numbers in the original when one of the temp arrays is finished
			    while (temp1Tracker < leastIndex) {
			        arr[origTracker++] = temp1[temp1Tracker++];
			    }
			    while (temp2Tracker < mostIndex) {
			        arr[origTracker++] = temp2[temp2Tracker++];
			    }
			}

}
