import java.util.ArrayList;

public class ThreeOrFive {
	ArrayList<Integer> list = null;

	public ThreeOrFive() {
		list = new ArrayList<>();
	}

	public ThreeOrFive(int length) {
		int i = 1;
		list = new ArrayList<>();
		while (i <= length) {
			this.list.add(i);
			i++;
		}
	}

	public ArrayList<Integer> isMultiple(int num1, int num2) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % num1 == 0 || list.get(i) % num2 == 0)
				result.add(list.get(i));
		}
		return result;

	}
	public static int sumArray(ArrayList<Integer> arr){
		int sum=0;
		for(int i=0; i<arr.size();i++){
			sum+= arr.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		ThreeOrFive one = new ThreeOrFive(999);
		System.out.println(sumArray(one.isMultiple(3, 5)));
		//System.out.println(one.list);

	}

}
