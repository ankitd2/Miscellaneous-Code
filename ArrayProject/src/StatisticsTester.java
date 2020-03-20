/*
 * this class is used to test all of the methods from the Statistics Class
 */
public class StatisticsTester {
/*
 * this method tests all of the methods from the Statistics class and prints them out in an orderly fashion
 */
	public static void callArray(double[] a) 
	{
		
		System.out.println("Given array:");
		Statistics.printArray(a);

		System.out.println("The mean for the given array is: " + Statistics.mean(a));
		System.out.println("The median for the given array is: " + Statistics.median(a));
		System.out.println("The range for the given array is: " + Statistics.range(a));
		System.out.println("The mode(s) for the given array is(are): " + Statistics.mode(a));
		System.out.println("The standard deviation for the data is: "+ Statistics.standardDeviation(a));
		System.out.println("The z-score for " + a[0] + " is :" + Statistics.zScore(a, a[0]));
		System.out.println();

	}

	public static void main(String[] args) {

		double[] test1 = { 1, 2, 3, 4, 5, 6, 7 };
		double[] test2 = { -1, -2, -3, -4, -5, -6, -7 };
		double[] test3 = { 0, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
		double[] test4 = { 9, 2, 6, 1, 8, 3, 5, 10, 3 };
		double[] test5 = { -7, 4, -2, 8, -9, 3, 2, -8 };
		double[] test6 = { -42, 3, 4.7, 8.4, -1, 0, 0, 200, 76, -8, -2.7, 1, 1, 1, 3 };
		double[] test7 = { 1, -5, 7 };
		double[] test8 = { 1, 2, 3, 3, 2, 1 };
		double[] test9 = { 1.1, 2.2, -1.1, -2.2, 4.89, 9.123, 0 };
		double[] test10= {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
		double[] test11= {0};
		double[] test12= {1};

		StatisticsTester.callArray(test1);
		StatisticsTester.callArray(test2);
		StatisticsTester.callArray(test3);
		StatisticsTester.callArray(test4);
		StatisticsTester.callArray(test5);
		StatisticsTester.callArray(test6);
		StatisticsTester.callArray(test7);
		StatisticsTester.callArray(test8);
		StatisticsTester.callArray(test9);
		StatisticsTester.callArray(test10);
		StatisticsTester.callArray(test11);
		StatisticsTester.callArray(test12);
		
	
	}
}
