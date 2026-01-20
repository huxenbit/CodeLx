package main;

public class CelsiusToFahrenheitStrategy extends ConversionStrategy {
	
	@Override
	public double convert(double value) {
		return (value * 9/5 + 32);
	}
}