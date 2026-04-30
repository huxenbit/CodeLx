package main;

public class CelsiusToKelvinStrategy implements ConversionStrategy {
	public double convert(double value) {
		return value + 273.15;
	}
}