import java.util.ArrayList;

/*
 * This Statistics class is used to find the mathematical mean, median, mode,and range from a given set of numbers from an
 *  array composed of doubles 
 */
public class Statistics {
	/*
	 * This static mean method receives an array of double a, and returns the
	 * mathematical mean as a double by adding up all the indices and dividing
	 * by the number of indices.
	 */
	public static double mean(double[] a) {
		double total = 0;
		for (double val : a) {
			total += val;
		}
		double mean = total / a.length;
		return mean;
	}
	/*
	 * This static method receives an array of doubles and returns a new array
	 * of doubles by copying the components of the original array. This is used
	 * as a helper method for the sort, range, and median methods so that the
	 * original array remains unchanged and other operations can be done to it.
	 */
	public static double[] copy(double[] a) {
		double[] copy = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		return copy;
	}
	/*
	 * This static method is used to print the array of doubles it receives.
	 */
	public static void printArray(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");

		}
		System.out.println();
	}
	/*
	 * This method is receives an array of doubles, and
	 * sorts the  array in ascending order
	 * 
	 */
	public static void sort(double[] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					double temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	/*
	 * this method receives an array of double values and returns the mathematical range between the least and greatest
	 * numbers by sorting the copy of the array and then subtracting them
	 */
	public static double range(double[] a) {
		double[] copy = Statistics.copy(a);
		Statistics.sort(copy);
		double smallest = copy[0];
		double largest = copy[copy.length - 1];
		double range = largest - smallest;
		return range;
	}
/*
 * the median method receives an array of double values and returns the median value without changing the original array  by creating a 
 * copy of the array and uses the sort and copy methods to create a sorted copy of the array. Then, based on the number of doubles in the array
 * it finds the median by either using the middle value or the average of the middle two.
 */
	public static double median(double[] a) {
		double[] copy = Statistics.copy(a);
		Statistics.sort(copy);
		double median;
		if (copy.length % 2 == 0)
			median = (copy[(copy.length - 1) / 2] + copy[(copy.length - 1) / 2 + 1]) / 2;
		else
			median = copy[(int) (((copy.length) / 2))];

		return median;
	}
/*
 * this method receives an array of doubles and returns an ArrayList of Doubles based on the mathematical mode which returns the number
 * that appears most often in the array. It keeps track of the occurrences of each number and returns multiple modes if there are multiple 
 * numbers with the same number of multiple occurrences
 */
	public static ArrayList<Double> mode(double[] a) {
		int maxCount = 0;
		ArrayList<Double> modes = new ArrayList<Double>();

		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = i; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (maxCount == count) {
				modes.add(a[i]);
			} else if (count > maxCount) {
				maxCount = count;
				modes.clear();
				modes.add(a[i]);
			}
		}
		if (maxCount == 1) {
			modes.clear();
		}
		return modes;
	}

/*
 * this method receives an array of doubles and returns the standard deviation in double based on the mathematical formula
 */
	public static double standardDeviation(double[] a) {
		double mean = mean(a);
		double sum = 0;
		for (double val : a) {
			sum += ((val - mean) * (val - mean));
		}
		double variance = (sum / a.length);
		double standardDeviation = Math.sqrt(variance);
		return standardDeviation;
	}
/*
 * this method receives an array of doubles a double value from the integer which is used to calculate the z-score and returns that double
 */
	public static double zScore(double[] a, double b) {
		double mean = mean(a);
		double zscore = ((b - mean) / standardDeviation(a));
		return zscore;

	}
}
