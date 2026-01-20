package main;
import java.util.Scanner;

public class MilesToKilometerStrategy extends ConversionStrategy {
	
	@Override
	public double convert(double value) {
		return value * 1.609;
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Gib die zu konvertierende Zahl ein (Meilen --> Kilometer): ");
		double miles = scanner.nextDouble();
		System.out.println("Converting " + miles + "miles to kilometer...");
		System.out.println("The answer is: " + convert(miles) + "km!");
		scanner.close();
	}
}