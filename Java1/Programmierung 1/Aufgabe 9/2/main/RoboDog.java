package main;

public class RoboDog extends Robot implements Pet {
	private boolean isCharged;
	private int batteryLife;

	public RoboDog(String newModel, boolean isCharged, int newBatteryLife) {
		super(newModel);
		this.isCharged = isCharged;
		this.batteryLife = newBatteryLife;
	}

	public int getBatteryLife() {
		return this.batteryLife;
	}

	public boolean getCharged() {
		return this.isCharged;
	}

	@Override
	public void play() {
		if (isCharged) {
			System.out.println(getModel() + " is playing fetch in simulation mode.");
		} else {
			System.out.println(getModel() + " cannot play while discharged.");
		}
	}

	@Override
	public void performTask() {
		if (isCharged) {
			System.out.println(getModel() + " is guarding the house.");
		} else {
			System.out.println(getModel() + " needs recharging before performing tasks.");
		}
	}

	public void recharge() {
		this.batteryLife = 100;
		System.out.println("Battery recharged: " + getBatteryLife() + "%!");
	}

	public void diagnostics() {
		System.out.println("batteryLife: " + getBatteryLife() + "%! - isCharged? Answer: " + getCharged());
	}
}