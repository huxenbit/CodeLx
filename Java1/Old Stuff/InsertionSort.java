import java.util.*;

class InsertionSort {
	
	private int[] array = new int[10];

	public void createArray() {
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}

		System.out.println("Array created!");
		System.out.println(Arrays.toString(array));
		System.out.println();
	}

	public int[] insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {

			for (int j = (i - 1); j >= 0; j--) {

				if (a[j] > a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}

		System.out.println("Array sorted!");
		System.out.println(Arrays.toString(getArray()));
		System.out.println();
		return a;
	}

	public int[] getArray() {
		return array;
	}
}