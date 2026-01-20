import java.util.*;

public class ArrayListsInJava {
	public static void main(String[] args) {
		Random generator = new Random();

		int[] numbers = new int[374];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(351);
		}

		System.out.println("Generated array with 10 random numbers:");
		System.out.println(Arrays.toString(SelectionSort(numbers)));

		int loops = 1;

		for (int number: numbers) {
			System.out.println("#" + loops + " -> " + number);
			loops++;
		}
	}

	public static int[] SelectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minPos = i;

			for (int j = i; j < array.length; j++) {
				if (array[j] < array[minPos]) {
					minPos = j;
				}
			}

			int t = array[i];
			array[i] = array[minPos];
			array[minPos] = t;
		}
		return array;
	}
}