import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LargestPrimeFactor {

	public LargestPrimeFactor() {
		long num = 600851475143L;
		ArrayList<Long> list = new ArrayList<>();
		long[] primeFactors = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 57, 59, 61, 67, 71 };

	}

	public static ArrayList<Long> divisors(long num1) {
		ArrayList<Long> factors = new ArrayList<>();
		for (long i = 1; i <= (num1); i++) {
			if (num1 % i == 0)
				factors.add(i);
		}

		return factors;
	}

	public static int isAPrime(long num) {
		int i;
		for (i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return 0;
			}
		}

		return 1;
	}

	public static long getPrime(long num) {
		long largestPrime = 0;
		for (int i = 0; i < num; i++) {
			if (isAPrime(i) == 1) {
				largestPrime = i;
			}
		}
		return largestPrime;
	}

	public static void main(String[] args) {
		long num1 = 600851475143L;
		long num2 = 13149400;
		// System.out.println(divisors(num1));
		// ArrayList<Long> list = divisors(num1);
		System.out.println(getPrime(num2));

	}
}
