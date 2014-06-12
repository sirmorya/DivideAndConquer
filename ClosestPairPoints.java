package divideAndConquer;

import java.util.Arrays;
import java.util.Comparator;

class Point {
	double x;
	double y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
}

class PointXComparator  implements Comparator<Point>{
	@Override
	public int compare(Point o1, Point o2) {
		
		if(o1 == null && o2 == null)
			return 0;
		else if(o1 == null)
			return -1;
		else if(o2 == null)
			return 1;
		else{
			if( o1.x == o2.x)
				return 0;
			else if( o1.x < o2.x)
				return -1;
			else
				return 1;
		}
		
		
	}
}


class PointYComparator  implements Comparator<Point>{
	@Override
	public int compare(Point o1, Point o2) {
		if(o1 == null && o2 == null)
			return 0;
		else if(o1 == null)
			return -1;
		else if(o2 == null)
			return 1;
		else{
			if( o1.y == o2.y)
				return 0;
			else if( o1.y < o2.y)
				return -1;
			else
				return 1;
		}
	}
}

/**
 * This class is used to find the closest pair of the points.
 * @author ankit
 *
 */
public class ClosestPairPoints {

	double dist(Point p1, Point p2){
		return Math.sqrt(((p1.x-p2.x)*(p1.x-p2.x)) + ((p1.y-p2.y)*(p1.y-p2.y)));
	}
	
	// A utility function to find minimum of two float values
	double min(double x, double y)
	{
	    return (x < y)? x : y;
	}
	
	double bruteForce(Point[] p, int n){
		double min = Double.MAX_VALUE; 
		for( int i = 0; i < n; i++)
			for(int j = i+1; j < n; j++)
				if(dist(p[i], p[j]) < min)
				 min = dist(p[i], p[j]);
		return min;
	}
	
	/**
	 * This method is used to return the minimum distance between the closest point in the strip.
	 * It looks like this method will have  a complexity of O(n ^ 2), but this method takes O(n) time
	 * as only 7 other points will lie at a distance < d. So, the time complexity will O(n).   
	 * @param points
	 * @param size
	 * @param d
	 * @return
	 */
	double stripClosest(Point[] points, int size, double d){
		double min = d;
		Arrays.sort(points,new PointYComparator());
		
		for(int i = 0; i < size && (points[i] != null); i++){
			for(int j = i+1; j < size  && (points[j] != null) && (points[j].y - points[i].y < d);j++)
				if(dist(points[i],points[j]) < min)
					min = dist(points[i],points[j]);
		}
		
		return min;
	}
	
	double closestUtil(Point[] points, int left, int right){
		int n = right-left;
		if(n<=3)
			//Calculatingt the minimum distance using brute Force approach
			return bruteForce(points, n);
		int mid = n/2;
		Point midPoint = points[ left+mid];
		//Fetching the minimum distance in the left half
		double dl = closestUtil(points, left, left+mid);
		//Fetching the minimum distance in the right half
		double dr = closestUtil(points, left+mid+1, right);
		//the minimum distance if the closest point doesn't cross the midpoint 
		double d = min(dl,dr);
		//Strip to store those points which lie across the mid point and the distance between them is less than the distance of points if they don't cross the midpoint
		Point[] strip = new Point[n];
		int j = 0;
		//Creating a strip of points whihc lie across the midpoint and their distance is less than the minimum distance fetched till now
		for(int i = left; i < right; i++)
			if((points[i].x - midPoint.x) < d){
				strip[j] = points[i];
				j++;
			}
		return min(d,stripClosest(strip, j, d));
				
	}
	
	/**
	 * Entry Point
	 * @param args
	 */
	public static void main(String[] args) {
		Point[] points = new Point[6];
		points[0] = new Point(2,3);
		points[1] = new Point(12,30);
		points[2] = new Point(40,50);
		points[3] = new Point(5,1);
		points[4] = new Point(12,10);
		points[5] = new Point(3,4);
		
		Arrays.sort(points,new PointXComparator());
		System.out.println(new ClosestPairPoints().closestUtil(points,0,points.length-1));
		//Time Complexity : T(n) = 2T(n/2) + nlgn;
		//                       => n lg(n)*lg(n) (by masters theorem)
	}
}
