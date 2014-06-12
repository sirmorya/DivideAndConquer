package divideAndConquer;

public class MinElemSortRotArray {

	int min(int x, int y) { return (x < y)? x :y; }
	
	int minInSortRotArray(int a[], int low, int high){
		
		if(high < low)
			return a[0];
		
		if(high == low)
			return a[low];
		
		int mid = (low + high)/2;
		
		//if mid value is the minimum element
		if(mid < high && (a[mid] < a[mid+1] && a[mid] < a[mid-1]))
			return a[mid];
		
		if(a[mid] == a[low] && a[mid] == a[high])
			return min(minInSortRotArray(a, low, mid-1), minInSortRotArray(a, mid+1, high));
		
		if(a[mid] < a[high])
			return minInSortRotArray(a, low, mid-1);
		else
			return minInSortRotArray(a, mid+1, high);
	}
	
	
	public static void main(String[] args) {
		int arr1[] =  {6, 7, 1, 2, 3, 4,5};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr1, 0, 6));
	 
	    int arr2[] =  {1, 1, 0, 1};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr2, 0, 3));
	 
	    int arr3[] =  {1, 1, 2, 2, 3};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr3, 0, 4));
	 
	    int arr4[] =  {3, 3, 3, 4, 4, 4, 4, 5, 3, 3};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr4, 0, 9));
	 
	    int arr5[] =  {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr5, 0, 11));
	 
	    int arr6[] =  {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr6, 0, 11));
	 
	    int arr7[] =  {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr7, 0, 11));
	    
	    int arr8[] =  {5,6, 1, 2, 3, 4};
	    System.out.println(new MinElemSortRotArray().minInSortRotArray(arr1, 0, 5));
	   
	}
}
