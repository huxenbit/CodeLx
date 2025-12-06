import java.util.*;

class BubbleSort {

	private int[] array = new int[10];

	public void createArray() {
		Random generator = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = generator.nextInt(10);
		}

		System.out.println("Array created!");
		System.out.println(Arrays.toString(array));
	}

	public int[] sort(int[] a) {
		for (int i = a.length; i > 0; i--) {

			for (int j = 0; j < (i - 1); j++) {

				if (a[j] > a[j+1]) {

					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}

		return a;
	}

	public int[] getArray() {
		return this.array;
	}
}