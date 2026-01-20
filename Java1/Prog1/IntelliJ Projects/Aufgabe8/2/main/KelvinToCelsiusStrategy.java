package main;

public class KelvinToCelsiusStrategy implements ConversionStrategy {
	public double convert(double value) {
		return value - 273.15;
	}
}