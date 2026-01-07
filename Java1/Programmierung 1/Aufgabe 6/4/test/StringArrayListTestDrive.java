package test;

import main.StringArrayList;
import java.util.*;

public class StringArrayListTestDrive {
	
	public static void main(String[] args) {
		StringArrayList array = new StringArrayList();

		//Test #1
		System.out.println("Test #1: getting and setting value at given index");
		System.out.println();
		array.set(0, "Test1");  				//Setting index 0 to value "Test1"
		array.set(1, "Test2");
		array.set(2, "Test3");
		array.set(3, "Test4");

		//Test #2
		System.out.println("Test #2: getting size of array");
		System.out.println();
		testInt(4, array.size());

		//Test #3
		System.out.println();
		System.out.println("Test #3: removing values");
		System.out.println();
		array.remove(0);	//Removing value at index 0

		//Test #4
		System.out.println();
		System.out.println("Test #4: adding values and resizing array");
		System.out.println();
		testInt(3, array.add("Test5")); //adding value at first free slot
		testInt(4, array.size());

		//Test #5
		System.out.println();
		System.out.println("Test #5: contains-method");
		System.out.println();
		System.out.println("Contains: Test4?: " + array.contains("Test5"));
		System.out.println();

		//Test #6
		System.out.println();
		System.out.println("Test #6: clear-method");
		System.out.println();
		array.clear(); //Clearing whole array

		//Test #7
		System.out.println();
		System.out.println("Test #7: toArray-method");
		System.out.println();
		System.out.println("toArray: " + array.toArray());

		//Test #8
		System.out.println();
		System.out.println("Test #8: isEmpty-method");
		System.out.println();
		System.out.println("isEmpty: " + array.isEmpty());

	}

	public static void testString(String expected, String actual) {
		if (Objects.equals(expected, actual)) {		//null-safe comparison 
			System.out.println("Correct! Expected: " + expected + " - Actual: " + actual);
		} else {
			System.out.println("False... Expected: " + expected + " - Actual: " + actual);
		}
	}

	public static void testInt(int expected, int actual) {
		if (expected == actual) {
			System.out.println("Correct! Expected: " + expected + " - Actual: " + actual);
		} else {
			System.out.println("False... Expected: " + expected + " - Actual: " + actual);
		}
	}
}