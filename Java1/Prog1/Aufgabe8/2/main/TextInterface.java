package main;

import java.util.Scanner;
import java.util.List;

public class TextInterface {

	private List<ConversionStrategy> strategies = List.of(
		new MilesToKilometerStrategy(),
		new KilometerToMilesStrategy(),
		new FahrenheitToCelsiusStrategy(),
		new CelsiusToFahrenheitStrategy(),
		new CelsiusToKelvinStrategy(),
		new KelvinToCelsiusStrategy());

		public void input() {
			Scanner scanner = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter 1 or 2: \n1: Convert\n2: Exit\n");
			int input = scanner.nextInt();
			double value = 0;

			int loop = 1;
			while (loop == 1) {
			if (input > 0 && input <= 2) {
				switch(input) {
					case 1: 
						input = 0;
						System.out.println();
						System.out.print("Enter 1, 2, 3 or 4: \n1: Miles to kilometer\n2: Kilometer to miles\n");
						System.out.print("3: Fahrenheit to celsius\n4: Celsius to fahrenheit\n5: Celsius to kelvin\n");
						System.out.println("6: Kelvin to celsius");
						input = scanner.nextInt();
						if (input > 0 && input <= 6) {
							System.out.print("\nEnter Value to convert: ");
							value = scanner.nextDouble();
						} else { return; } //ERROR = END
						break;

					case 2: return;

					default: return; //ERROR = END
				}
			} else { return; }
			System.out.println("Converting...");
			System.out.println("Result: " + strategies.get(input - 1).convert(value));
			System.out.println("Do you wish to convert again?\n 1: Continue\n 2: Exit");
			loop = scanner.nextInt();
		}
	}
}