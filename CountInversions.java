package divideAndConquer;

/**
 * This class is used to calculate the number of inversions required to sort an array
 * @author ankitsirmorya
 *
 */
public class CountInversions {

	public static void main(String[] args) {
		int a[] = {1, 20, 6, 4, 5}; 
		System.out.println(new CountInversions().mergeSort(a, new int[a.length], 0, a.length-1));
		
	}
	
	/**
	 * This is a modified merge sot partitioning method which returns the number of inversions required.
	 * 
	 * @param a
	 * @param t
	 * @param left
	 * @param right
	 * @return
	 */
	int mergeSort(int[] a,int[] t, int left, int right){
		int mid, invCount = 0;
		if( right > left){
			mid = (left + right)/2;
			invCount = mergeSort(a, t,left, mid);
			invCount += mergeSort(a, t, mid+1, right);
			invCount += merge(a, t, left, mid, right);
		}
		return invCount;
	}
	
	int merge(int[] a, int[] temp, int left, int mid, int right){
		
		int i = left, j = mid, k= left, invCount = 0;
		while( (i <= mid - 1) && (j <= right) ){
			if(a[i] <= a[j])
				temp[k++] = a[i++];
			else{
				temp[k++] = a[j++];
				//All the elements greater in the left block will be greater than  a[j]
				invCount += (mid - i);
			}
		}
		
		while(i < (mid - 1))
			temp[k++] = a[i++];
		
		while(j < right)
			temp[k++] = a[j++];
		
		for( i = left; i <= right; i++)
			a[i] = temp[i];
		
		return invCount;
	}
}
