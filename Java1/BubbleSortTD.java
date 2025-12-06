import java.util.*;


public class BubbleSortTD {
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();

		System.out.println("# Bubble Sort");
		System.out.println();

		System.out.println("Test #1: Create array");
		bs.createArray();
		testArray(bs.getArray());
		System.out.println();

		System.out.println("Test #2: Sort");
		System.out.println(Arrays.toString(bs.sort(bs.getArray())));

	}

	public static void testArray(int[] a) {
		if (a.length > 0) {
			System.out.println("Array exists!");
		} else {
			System.out.println("Array does not exist!");
		}
	}
}