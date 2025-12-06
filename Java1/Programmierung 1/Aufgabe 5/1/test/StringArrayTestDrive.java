package test;

import main.StringArray;
import java.util.Objects;

public class StringArrayTestDrive {
	
	public static void main(String[] args) {
		StringArray array = new StringArray();

		//Test #1
		System.out.println("Test #1: getting and setting value at given index");
		System.out.println();
		array.set(0, "Test1");  				//Setting index 0 to value "Test1"
		testString("Test1", array.get(0));
		array.set(-1, "NotInArray"); 			//Checking error handling 1)
		array.set(4, null);				
		testString(null, array.get(20));		//Checking error handling 2)
		testString(null, array.get(3));
		System.out.println();
		array.set(2, "Test2");

		//Test #2
		System.out.println("Test #2: getting size of array");
		System.out.println();
		testInt(2, array.size());

		//Test #3
		System.out.println();
		System.out.println("Test #3: removing values");
		System.out.println();
		array.remove(0);	//Removing value at index 0
		array.remove(2);	//Removing value at index 2
		testString(null, array.get(0));
		array.remove(5);	//Checking error handling 1)
		array.remove(-1);	//Checking error handling 2)
		array.remove(90);	//Checking error handling 3)

		//Test #4
		System.out.println();
		System.out.println("Test #4: adding values and resizing array");
		System.out.println();
		testInt(0, array.add("Test4"));
		testInt(1, array.size());
		array.add(null);	//Checking error handling



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