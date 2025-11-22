class Plant {

	private double height1; //m
	private double height2;
	private String type;
	private int waterLevel; //l
	private boolean isEqual;


	void grow(int sunlightHours) {

		height1 = height1 + (0.5 * sunlightHours);

		print(type + " has grown by " + (sunlightHours * 0.5) + "m!");
		print("And is now at: " + height1 + "m!");

	}

	void water(int amount) {

		waterLevel += amount;

		print("Water level has risen by: " + amount + "l!");
		print("And is now at: " + waterLevel + "l!");

	}

	boolean needsWater() {

		if (waterLevel < 10) {

			return true;

		} else {

			return false;

		}

	}

	double getHeight() {

		return height1;

	}

	void setHeight(double height) {
		if (height >= 0) {
			this.height1 = height;
			this.height2 = height;
		} else {
			print("Error! Negative height impossible!");
		}

	}

	String getType() {

		return type;

	}

	void setType(String type) {

		this.type = type;

	}

	int getWaterLevel() {

		return waterLevel;

	}

	void setWaterLevel(int waterLevel) {

		if (waterLevel < 10) {
			this.waterLevel = waterLevel;
		} else {
			print("Error! Too much water!");
		}

	}

	void setIsEqual() {

		this.isEqual = (height1 == height2);
		
	}

	boolean getIsEqual() {

		return isEqual;

	}

	void print(String text) {

		System.out.println(text);

	}
}