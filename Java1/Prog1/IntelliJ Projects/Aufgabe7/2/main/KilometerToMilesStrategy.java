package main;

public class KilometerToMilesStrategy extends ConversionStrategy {
	
	@Override
	public double convert(double value) {
		return value * 0.621;
	}
}