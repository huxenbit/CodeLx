package main;

public class RoboDog extends Robot implements Pet {
	private boolean isCharged;
	private int batteryLife;

	public int getBatteryLife() {
		return this.batteryLife;
	}

	public void setBatteryLife(int newBatteryLife) {
		if (newBatteryLife > 0) {
			this.batteryLife = newBatteryLife;
		}
	}

	public boolean getCharged() {
		return this.isCharged;
	}

	public void setCharged(boolean charged) {
		this.isCharged = charged;
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
		setBatteryLife(100);
		System.out.println("Battery recharged: " + getBatteryLife() + "%!");
	}

	public void diagnostics() {
		System.out.println("batteryLife: " + getBatteryLife() + "%! - isCharged? Answer: " + getCharged());
	}
}