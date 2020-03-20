
public class Palindrome {

	public static int findLargestNum() {
		int k = 0;

		boolean isPalindrome = false;
		int largestPalindrome = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				k = i * j;
				String kString = new Integer(k).toString();
				for (int l = 0; l < (kString.length() / 2) ; l++) {
					if (kString.charAt(l) == kString.charAt(kString.length() - l - 1)) {
						isPalindrome = true;
					} else {
						isPalindrome=false;
						break;
					}

				}
				if (isPalindrome && k>largestPalindrome) {
					largestPalindrome = k;
				}

			}
		}
		return largestPalindrome;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLargestNum());

	}

}
