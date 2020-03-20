import java.util.ArrayList;

public class EvenFibonnaci {
	static int sum = 0;

	public static int fibonnaci(long num) {
		if (num == 1)
			return 1;
		if (num == 2)
			return 2;
		return fibonnaci(num - 1) + fibonnaci(num - 2);
	}

	public static int getSum() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i < 33; i++) {
			list.add(fibonnaci(i));
		}
		for (int i : list) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonnaci(32));
		System.out.println(getSum());

	}

}
