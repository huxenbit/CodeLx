package test;

import main.KilometerToMilesStrategy;
import main.MilesToKilometerStrategy;
import main.FahrenheitToCelsiusStrategy;
import main.CelsiusToFahrenheitStrategy;

public class ConversionTestDrive {
	public static void main(String[] args) {
		KilometerToMilesStrategy kilo = new KilometerToMilesStrategy();
		MilesToKilometerStrategy miles = new MilesToKilometerStrategy();
		FahrenheitToCelsiusStrategy fhh = new FahrenheitToCelsiusStrategy();
		CelsiusToFahrenheitStrategy cls = new CelsiusToFahrenheitStrategy();

		//Test 1 kilometer --> miles
		System.out.println("Test #1: Kilometer --> Miles");
		System.out.println(kilo.convert(9));
		test(6.21, kilo.convert(10));
		System.out.println();

		//Test 2 miles --> kilometer
		System.out.println("Test #2: Miles --> Kilometer");
		System.out.println(miles.convert(5));
		test(16.09, miles.convert(10));
		System.out.println();

		//Test 3 input (miles --> kilometer)
		System.out.println("Test #3: Input (Miles --> Kilometer)");
		miles.input();
		System.out.println();

		//Test 4 fahrenheit --> celsius
		System.out.println("Test #4: Fahrenheit --> Celsius");
		System.out.println(fhh.convert(68));
		test(0.0, fhh.convert(32));
		System.out.println();

		//Test 5 celsius --> fahrenheit
		System.out.println("Test #5: Celsius --> Fahrenheit");
		System.out.println(cls.convert(20));
		test(32, cls.convert(0));


	}

	public static void test(double expected, double actual) {
		if ((expected - actual) == 0) {
			System.out.println("Correct! Expected: " + expected + " - Actual: " + actual);
		} else {
			System.out.println("False! Expected: " + expected + " - Actual: " + actual);
		}
	}
}