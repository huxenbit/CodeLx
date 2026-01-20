package main;

public class Dragon extends Animal {
	private int firePower;
	private double wingSpan;

	public int getFirePower() {
		return this.firePower;
	}

	public void setFirePower(int newFirePower) {
		if (newFirePower > 0) {
			this.firePower = newFirePower;
		}
	}

	public double getWingSpan() {
		return this.wingSpan;
	}

	public void setWingSpan(double newWingSpan) {
		if (newWingSpan > 0) {
			this.wingSpan = newWingSpan;
		}
	}

	@Override
	public void makeSound() {
		System.out.println(getName() + " roars and breathes fire!");
	}

	public void fly() {
		System.out.println(getName() + " flies through the sky!");
	}

	public void breatheFire() {
		System.out.println(getName() + " breathes fire!");
	}
}