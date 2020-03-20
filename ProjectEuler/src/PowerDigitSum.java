
public class PowerDigitSum {
//	public static double getSum() {
//		return Math.pow(2, 1000);
//	}

	public static void main(String[] args) {
		//System.out.println(Math.pow(2, 1000));
        long num = new Long((long) Math.pow(2, 1000));
        System.out.println(num);
        int sum = 0;
        while (num > 0) {
            sum = sum + (int)(num % 10);
            num = num / 10;
        }
        System.out.println(sum);
    }

}
