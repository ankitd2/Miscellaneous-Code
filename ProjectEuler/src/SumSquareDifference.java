
public class SumSquareDifference {
	
	public static long sumSquares(int n) {
		long sum= (2*n+1)*(n+1)*n/6;
		return sum;
	}
	public static long squareSum(int n) {
		long sum= n*(n+1)/2;
		return sum*sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long sum = sumSquares(106660);
		long sum2 = squareSum(106660);
		System.out.println(sum2-sum);
	}

}
