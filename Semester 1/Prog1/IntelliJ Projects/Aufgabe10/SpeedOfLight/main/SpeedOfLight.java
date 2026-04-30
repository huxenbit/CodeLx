package main;

import java.util.Locale;

public class SpeedOfLight {
	public static final long SPEED = 299_792_458; // m pro sek

	public static double fraction(double factor) {
		return ((double) SPEED) * factor;
	}

	public static void printFraction(double factor) {
		System.out.format(Locale.GERMANY, "Multipliziert mit %.3f: %,d m/s\n", factor, (long) fraction(factor));
	}
}