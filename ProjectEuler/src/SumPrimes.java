import java.util.ArrayList;

public class SumPrimes {
	public static long getPrime(int n) {
		long num = 2;
		boolean isPrime = true;
		int count = 0;
		upper: while (true) {
			inner: for (int i = 2; i <= (Math.sqrt(num)); i++) {
				if (num % i == 0) {
					isPrime = false;
					break inner;
				}
				if (num == i) {
					isPrime = true;
				}
			}
			if (isPrime) {
				count++;
			}

			if (count == n) {
				break;
			}
			num++;
			isPrime = true;
		}
		return num;
	}

	public static long sumAllPrimes() {
		long sum = 0;
		for (int i = 2; i < 2000000; i++) {
			if (isAPrime(i) == 1) {
				sum += i;
			}
		}
		return sum;
	}

	public static int isAPrime(int num) {
		int i;
		for (i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return 0;
			}
		}

		return 1;
	}

	public static void main(String[] args) {

		System.out.println(sumAllPrimes());
	}

}
