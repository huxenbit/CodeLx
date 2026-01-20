package main;

public class MilesToKilometerStrategy implements ConversionStrategy {
	public double convert(double value) {
		return value * 1.609;
	}
}