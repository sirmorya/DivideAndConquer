package DivideAndConquer;

public class GetExcelColName {

	String getExcelColName(int index){
		
		int quotient = index / 26;
		if( quotient > 0){
			return getExcelColName(quotient-1) + (char)((index % 26) + 65);
		}else{
			return String.valueOf((char)((index % 26) + 65));
		}
	}
	
	public static void main(String[] args) {
		int i = 728;
		System.out.println(new GetExcelColName().getExcelColName(i-1));
	}
}
