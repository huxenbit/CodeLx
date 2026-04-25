package de.htwsaar.esch.Codeopolis.DomainModel.Plants;

import java.util.Random;

/**
 * The `Conditions` class represents environmental conditions that affect plant growth.
 * It includes information about soil conditions, average summer temperature, and average winter temperature.
 */
public class Conditions {

	private float soilConditions;
	private float averageTemperatureSummer;
	private float averageTemperatureWinter;

	private boolean drought;
	private boolean fusarium;
	private boolean leafDrought;
	private boolean powderyMildew;
	private boolean barleyGoutFly;
	private boolean deliaFly;
	private boolean fritFly;

	/**
     * Constructs a new `Conditions` object with specified values for soil conditions and temperatures.
     *
     * @param soilConditions         The soil conditions affecting plant growth (a float value between 0.0 and 1.0).
     * @param averageTemperatureSummer The average summer temperature (in degrees Celsius).
     * @param averageTemperatureWinter The average winter temperature (in degrees Celsius).
     */
	public Conditions(float soilConditions, float averageTemperatureSummer, float averageTemperatureWinter, boolean drought,
					  boolean fusarium, boolean leafDrought, boolean powderyMildew, boolean barleyGoutFly, boolean deliaFly,
					  boolean fritFly) {

		this.soilConditions = soilConditions;
		this.averageTemperatureSummer = averageTemperatureSummer;
		this.averageTemperatureWinter = averageTemperatureWinter;

		this.drought = drought;
		this.fusarium = fusarium;
		this.leafDrought = leafDrought;
		this.powderyMildew = powderyMildew;
		this.barleyGoutFly = barleyGoutFly;
		this.deliaFly = deliaFly;
		this.fritFly = fritFly;
	}

	/**
	 *  Following are several small getter-methods for private booleans.
	 */
	public boolean isDrought() {
		return this.drought;
	}

	public boolean isFusarium() {
		return this.fusarium;
	}

	public boolean isLeafDrought() {
		return this.leafDrought;
	}

	public boolean isPowderyMildew() {
		return this.powderyMildew;
	}

	public boolean isBarleyGoutFly()  {
		return this.barleyGoutFly;
	}

	public boolean isDeliaFly() {
		return this.deliaFly;
	}

	public boolean isFritFly() {
		return this.fritFly;
	}

    /**
     * Gets the soil conditions affecting plant growth.
     *
     * @return The soil conditions (a float value between 0.0 and 1.0).
     */
	public float getSoilConditions() {
		return soilConditions;
	}

    /**
     * Gets the average summer temperature.
     *
     * @return The average summer temperature (in degrees Celsius).
     */
	public float getAverageTemperatureSummer() {
		return averageTemperatureSummer;
	}

    /**
     * Gets the average winter temperature.
     *
     * @return The average winter temperature (in degrees Celsius).
     */
	public float getAverageTemperatureWinter() {
		return averageTemperatureWinter;
	}
	
	/**
	 * Factory method to create a new Conditions object with random values for all fields.
	 *
	 * @return A new Conditions object with random values.
	 */
	public static Conditions generateRandomConditions() {
		Random random = new Random();
		float soilConditions = random.nextFloat(); // generates a random float value between 0.0 (inclusive) and 1.0 (exclusive)
		float averageTemperatureSummer = random.nextFloat() * 30.0f; // generates a random float value between 0.0 (inclusive) and 30.0 (exclusive)
		float averageTemperatureWinter = random.nextFloat() * 20.0f - 10.0f; // generates a random float value between -10.0 (inclusive) and 10.0 (exclusive)

		/**
		 * Generating random events from City.runTurn()-method
		 */
		boolean drought = random.nextFloat() > 0.8;
		boolean fusarium = random.nextFloat() > 0.8;
		boolean leafDrought = random.nextFloat() > 0.8;
		boolean powderyMildew = random.nextFloat() > 0.8;
		boolean barleyGoutFly = random.nextFloat() > 0.8;
		boolean deliaFly = random.nextFloat() > 0.8;
		boolean fritFly = random.nextFloat() > 0.8;

		return new Conditions(soilConditions, averageTemperatureSummer, averageTemperatureWinter, drought, fusarium, leafDrought,
							  powderyMildew, barleyGoutFly, deliaFly, fritFly);
	}
}
