import java.util.ArrayList;

public class SmallestMultiple {
	public static ArrayList<Integer> divisors(int num1) {
		ArrayList<Integer> factors = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			if (num1 % i == 0)
				factors.add(i);
		}

		return factors;
	}

	public static int findNum() {
		int num = 0;
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 100000000; i < 300000000; i++) {
			list = divisors(i);
			if (list.size() >= 20) {
				for (int j = 0; j < 20; j++) {
					sum += list.get(j);
				}
				if (sum == 210) {
					num = i;
				} else {
					sum = 0;
				}
			}

		}
		return num;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = divisors(232792560);
		
		System.out.println(findNum());
		System.out.println(list);

	}

}
