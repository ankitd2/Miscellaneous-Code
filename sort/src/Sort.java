import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Sort {

	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[min] > list[j]) {
					min = j;
				}
			}
			int temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
	}

	public static void selectionSort(ArrayList<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(min).compareTo(list.get(j)) > 0) {
					min = j;
				}
			}
			String temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
	}

	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int min = list[i];
			int j = i;
			for (j = i; j > 0 && list[j - 1] > min; j--) {
				list[j] = list[j - 1];
			}
			list[j] = min;

		}
	}

	public static void insertionSort(ArrayList<String> list) {
		for (int i = 1; i < list.size(); i++) {
			String min = list.get(i);
			int j = i;
			for (j = i; j > 0 && list.get(j - 1).compareTo(min) > 0; j--) {
				list.set(j, list.get(j - 1));
			}
			list.set(j, min);

		}
	}

	// public static int[] mergeSort(int[] list) {
	// if (list.length == 0 || list.length == 1)
	// return list;
	//
	// int[] left = new int[list.length / 2];
	// for (int i = 0; i < list.length / 2; i++) {
	// left[i] = list[i];
	// }
	// int[] right = new int[list.length - left.length];
	// for (int i = list.length / 2; i <= list.length - 1; i++) {
	// right[i - list.length / 2] = list[i];
	// }
	// System.out.println("Left: ");
	// printArray(left);
	// System.out.println("right: ");
	// printArray(right);
	// if (left.length == 0 || left.length == 1)
	// return left;
	// if (right.length == 0 || right.length == 1)
	// return right;
	// mergeSort(left);
	// mergeSort(right);
	//
	// int totalArray = 0;
	// int leftIndex = 0;
	// int rightIndex = 0;
	// while (totalArray < list.length) {
	// if ((leftIndex < left.length) && (rightIndex < right.length)) {
	// if (left[leftIndex] < right[rightIndex]) {
	// list[totalArray] = left[leftIndex];
	// totalArray++;
	// leftIndex++;
	// } else {
	// list[totalArray] = right[rightIndex];
	// totalArray++;
	// rightIndex++;
	// }
	// } else {
	// if (leftIndex <= left.length) {
	// while (rightIndex < right.length) {
	// list[totalArray] = right[rightIndex];
	// totalArray++;
	// rightIndex++;
	// }
	// }
	// if (rightIndex <= right.length) {
	// while (leftIndex < left.length) {
	// list[totalArray] = left[leftIndex];
	// leftIndex++;
	// totalArray++;
	// }
	// }
	// }
	// }
	// return list;
	// }
	public static void mergeSort(int[] list) {
		if (list.length == 0 || list.length == 1)
			return;
		int[] left = new int[list.length / 2];
		for (int i = 0; i < list.length / 2; i++) {
			left[i] = list[i];
		}
		int[] right = new int[list.length - left.length];
		for (int i = list.length / 2; i < list.length; i++) {
			right[i - list.length / 2] = list[i];
		}
		mergeSort(left);
		mergeSort(right);
		int bigIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				list[bigIndex] = left[leftIndex];
				bigIndex++;
				leftIndex++;
			} else {
				list[bigIndex] = right[rightIndex];
				bigIndex++;
				rightIndex++;
			}
		}
		while (leftIndex < left.length) {
			list[bigIndex] = left[leftIndex];
			bigIndex++;
			leftIndex++;
		}
		while (rightIndex < right.length) {
			list[bigIndex] = right[rightIndex];
			bigIndex++;
			rightIndex++;
		}
	}

	public static void mergeSort(ArrayList<String> list) {
		if (list.size() == 0 || list.size() == 1)
			return;
		ArrayList<String> left = new ArrayList<String>(list.subList(0, list.size() / 2));
		ArrayList<String> right = new ArrayList<String>(list.subList(list.size() / 2, list.size()));
		mergeSort(left);
		mergeSort(right);
		int bigIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		// while both have numbers
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
				list.set(bigIndex, left.get(leftIndex));
				bigIndex++;
				leftIndex++;
			} else {
				list.set(bigIndex, right.get(rightIndex));
				bigIndex++;
				rightIndex++;
			}
		}
		// if right runs out
		while (leftIndex < left.size()) {
			list.set(bigIndex, left.get(leftIndex));
			bigIndex++;
			leftIndex++;
		}
		// if left runs out
		while (rightIndex < right.size()) {
			list.set(bigIndex, right.get(rightIndex));
			bigIndex++;
			rightIndex++;
		}
	}

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static void quickSort(int[] list, int beg, int end) {
//		if (list.length > 1) {

			int start = beg;
			int last = end;
			int pivot = list[(beg + end) / 2];

			while (start <= last) {
				while (list[start] < pivot) {
					start++;
				}
				while (list[last] > pivot) {
					last--;
				}
				if (start <= last) {
					int temp = list[start];
					list[start] = list[last];
					list[last] = temp;
					start++;
					last--;
				}
			}

			if (beg < last)
				// pivot = list[last];
				quickSort(list, beg, last);

			else if (start < end)
				quickSort(list, start, end);

		}
	
	public static void quickSort(ArrayList<String> list) {
		quickSort(list, 0, list.size() - 1);
	}

	public static void quickSort(ArrayList<String>list, int beg, int end) {
//		if (list.size() > 1) {

			int start = beg;
			int last = end;
			String pivot = list.get((beg+ end)/2);

			while (start <= last) {
				while (list.get(start).compareTo(pivot) < 0) {
					start++;
				}
				while (list.get(last).compareTo(pivot) > 0) {
					last--;
				}
				if (start <= last) {
					String temp = list.get(start);
					list.set(start, list.get(last));
					list.set(last, temp);
					start++;
					last--;
				}
			}

			if (beg < last)
				// pivot = list[last];
				quickSort(list, beg, last);

			else if (start < end)
				quickSort(list, start, end);

		}
	
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = { 3, 2, 6, 7, 5, 1 };
		int[] test2 = { 93, 105, -12, 80, -23, 8, 5 };
		ArrayList<String> test3 = new ArrayList<String>();
		int[] test4 = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5,
				-6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20 };
		int[] test5 = { -12, 312, 54, 456, 74, -123, 69, 234, 045, 23, 421, 495, 382, 495, 183, 506 };
		ArrayList<String> test6 = new ArrayList<String>();
//		printArray(test5);
//		quickSort(test5);
//		printArray(test5);

		// testing(test);
		// testing(test2);
		//
		// test3.add("Andy");
		// test3.add("Marshall");
		// test3.add("1 pizza");
		// test3.add(" spacebar");
		// test3.add(" ");
		// test3.add("y'all");
		// test3.add("Hi");
		// test3.add("him");
		// test3.add("java");
		 test6.add("1");
		 test6.add("5");
		 test6.add("4");
		 test6.add("3");
		 test6.add("-1");
		 test6.add("-1");
		 test6.add("1");

		// System.out.println(test3);
		// insertionSort(test3);
		// System.out.println(test3);
		 System.out.println(test6);
		 quickSort(test6);
		 System.out.println(test6);

	}

	public static void testing(int[] a) {
		System.out.println("Original Array");
		printArray(a);
		selectionSort(a);
		System.out.println("Selection sort");
		printArray(a);
		System.out.println("");
	}
}