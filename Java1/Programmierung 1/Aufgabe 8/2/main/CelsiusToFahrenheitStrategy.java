package main;

public class CelsiusToFahrenheitStrategy implements ConversionStrategy {
	public double convert(double value) {
		return (value * 9/5 + 32);
	}
}