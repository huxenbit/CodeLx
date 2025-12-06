import java.util.*;

public class InsertionSortTD {
	
	public static void main(String[] args) {

		InsertionSort i = new InsertionSort();

		System.out.println("# Insertion Sort");
		System.out.println();

		System.out.println("Test #1: Create Array");
		i.createArray();

		System.out.println("Test #2: Sort Array");
		i.insertionSort(i.getArray());
		
	}
}