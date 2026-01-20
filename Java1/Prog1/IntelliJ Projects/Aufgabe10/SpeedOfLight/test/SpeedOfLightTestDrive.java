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

		SpeedOfLight.printFraction(randomNum);
///////////////////////////////////////////////////////
		randomNum = Math.random();

		//inkludiere 1 wenn randomNum sehr nah dran ist
		if (randomNum >= 0.9999) {
			randomNum = 1.0;
		}

		SpeedOfLight.printFraction(randomNum);
//////////////////////////////////////////////////////
		randomNum = Math.random();

		//inkludiere 1 wenn randomNum sehr nah dran ist
		if (randomNum >= 0.9999) {
			randomNum = 1.0;
		}

		SpeedOfLight.printFraction(randomNum);
	} 
}