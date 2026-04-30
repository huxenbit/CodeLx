package main;

public class KilometerToMilesStrategy implements ConversionStrategy {
	public double convert(double value) {
		return value * 0.621;
	}
}