import java.util.ArrayList;

public class GetNthPrime {

	public static int getPrime(int n) {
		int num = 2;
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

	public static int isAPrime(int num) {
		int i;
		for (i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return 0;
			}
		}

		return 1;
	}

	public static ArrayList<Integer> getPrime(ArrayList<Integer> factors) {
		ArrayList<Integer> list = new ArrayList<>();
		boolean isPrime = true;
		for (int l : factors) {
			isPrime = true;
			for (int i = 2; i <= (Math.sqrt(l)); i++) {
				if (l % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				list.add(l);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(getPrime(1482));

	}

}
