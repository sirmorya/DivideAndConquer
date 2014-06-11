package DivideAndConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Point {
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class PointXComparator  implements Comparator<Point>{
	@Override
	public int compare(Point o1, Point o2) {
		if( o1.x == o2.x)
			return 0;
		else if( o1.x < o2.x)
			return -1;
		else
			return 0;
	}
}


class PointYComparator  implements Comparator<Point>{
	@Override
	public int compare(Point o1, Point o2) {
		if( o1.x == o2.x)
			return 0;
		else if( o1.x < o2.x)
			return -1;
		else
			return 0;
	}
}

/**
 * This class is used to find the closest pair of the points.
 * @author ankit
 *
 */
public class ClosestPairPoints {

	double dist(Point p1, Point p2){
		return Math.sqrt(((p1.x-p2.x)*(p1.x-p2.x)) - ((p1.y-p2.y)*(p1.y-p2.y)));
	}
	
	double bruteForce(Point[] p, int n){
		double min = Float.MAX_VALUE; 
		for( int i = 0; i < n-1; i++)
			for(int j = i+1; j < n; j++)
				min = dist(p[i], p[j]);
		return min;
	}
	
	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<Point>();
		Collections.sort(points,new PointXComparator());
	}
}
