import java.util.Random;
import java.util.Arrays;

public class BubbleSortDemo {
	static Random rand = new Random();
	static int[] array = new int[rand.nextInt(30) + 1];


	//Main method
	public static void main(String[] args) {
		iterateArray();
		output();
		bubbleSort();
		output();
	}

	//Swapping contents
	public static void swap(int index) {
		int temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}

	//Creates array content
	public static void iterateArray() {
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(30);
		}
	}

	//Bubble sorting
	public static void bubbleSort() {
		boolean swapped = false;
		for (int i = array.length; i > 0; i--) {
			for (int j = 0; j < (i - 1); j++) {
				if (array[j] > array[j + 1]) {
					swap(j);
					swapped = true;
				}
			}
			if (!swapped) break; //stop if already sorted
		}
	}

	//Prints arrays
	public static void output() {
		System.out.println(Arrays.toString(array));
	}
}