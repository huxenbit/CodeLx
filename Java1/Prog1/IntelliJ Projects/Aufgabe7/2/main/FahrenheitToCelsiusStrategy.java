package main;

public class FahrenheitToCelsiusStrategy extends ConversionStrategy {
	
	@Override
	public double convert(double value) {
		return (value - 32) * 5/9;
	}
}