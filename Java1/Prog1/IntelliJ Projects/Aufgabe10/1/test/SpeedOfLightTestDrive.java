package test;

import main.SpeedOfLight;

import java.util.Locale;

public class SpeedOfLightTestDrive {
	public static void main(String[] args) {

		//1. Gib Kosntante auf Konsole aus
		System.out.format(Locale.GERMAN, "Speed: %,d m/s \n", SpeedOfLight.SPEED);

		//2. multipliziere mit faktor zwischen 0 und 1
		double randomNum = Math.random();

			//inkludiere 1 wenn randomNum sehr nah dran ist
		if (randomNum >= 0.9999) {
			randomNum = 1.0;
		}

		System.out.format(Locale.GERMAN, "Multipliziert mit %.3f: %,d m/s \n", randomNum, (long) SpeedOfLight.fraction(randomNum));
	} 
}