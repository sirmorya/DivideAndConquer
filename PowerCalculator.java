package divideAndConquer;

public class PowerCalculator {

	
	float power(int x, int y){
		if( y == 0)
			return 1;
		float temp  = power(x, y/2);
		if(y/2 == 0)
			return temp * temp;
		else{
			if(y > 0)
				return x * temp * temp;
			else
				return (temp * temp)/x; 
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new PowerCalculator().power(2,-2));
	}
	
}
