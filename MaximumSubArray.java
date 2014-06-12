package DivideAndConquer;

public class MaximumSubArray {

	// A utility funtion to find maximum of two integers
	int max(int a, int b) { return (a > b)? a : b; }
	 
	// A utility funtion to find maximum of three integers
	int max(int a, int b, int c) { return max(max(a, b), c); }
	
	/**
	 * This method returns the maximum sum of the sub array which crosses the left sub-arra and the left sub-array.
	 * @param a
	 * @param l
	 * @param m
	 * @param h
	 * @return
	 */
	int maxCrossingSum(int[] a, int l, int m, int h){
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		for( int i = l; i <= m; i++){
			sum += a[i];
			if( sum > leftSum)
				leftSum = sum;
		}
		
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for( int i = m+1; i <= h; i++){
			sum += a[i];
			if( sum > rightSum)
				rightSum = sum;
		}
		return leftSum + rightSum;	
	}
	
	int maxSubArray(int[] a, int l, int h){
		if( l == h)
			return a[l];
		int m = (l + h)/2;
		
		return max(maxSubArray(a, l, m), maxSubArray(a, m+1, h), maxCrossingSum(a, l, m, h));
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 5, 7};
		System.out.println(new MaximumSubArray().maxSubArray(arr, 0, 4));
	}
}
