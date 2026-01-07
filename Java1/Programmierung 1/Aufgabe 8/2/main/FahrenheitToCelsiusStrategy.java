package main;

public class FahrenheitToCelsiusStrategy implements ConversionStrategy {
	public double convert(double value) {
		return (value - 32) * 5/9;
	}
}