package divideAndConquer;

/**
 * This class is used to determine the number of occurences of a character in a sorted array.
 * 
 * @author ankitsirmorya
 *
 */
public class NoOfOccurences {

	
	/**
	 * This method is used to find the occurrences of a integer in an array of sorted integers.
	 * @param a
	 * @param x
	 * @return
	 */
	void findOccurrences(int[] a, int x){
		
		// Finding the first occurence of the integer in the array
		int i = find(a, 0, a.length - 1, x);
		
		if ( i == -1)
			System.out.println("Not Found");
		
		int j = last(a,i, a.length -1, x);
		System.out.println(j-i+1);
	}
	
	/**
	 * This method finds the first occurence of the integer.
	 * @param a
	 * @param l
	 * @param h
	 * @param x
	 * @return
	 */
	int find(int a[], int l, int h, int x){
		
		int m = (l + h)/2;
		if(l <= h){
			if((m == 0 || x > a[m-1]) && (a[m] == x))
				return m;
			if(x > a[m])
				return find(a, m+1,h,x);
			else
				return find(a, l, m-1, x);
		}
		
		return -1;
	}
	
    /**
     * This method is used to find the last occurence of the integer in the array.
     * 
     * @param a
     * @param l
     * @param h
     * @param x
     * @return
     */
    int last(int a[], int l, int h, int x){
		
		int m = (l + h)/2;
		if(l <= h){
			if((m == a.length-1 || x < a[m+1]) && (a[m] == x))
				return m;
			if(x < a[m])
				return last(a, l, m-1, x);
			else
				return last(a, m+1, h, x);
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		int a[] = {1,2,2,2,2,2,2,2,5,6,7,7,8,8,8,9,9,9,9,9,9};
		new NoOfOccurences().findOccurrences(a, 9);
		
	}
}
