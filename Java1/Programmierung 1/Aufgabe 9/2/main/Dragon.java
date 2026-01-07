package main;

public class Dragon extends Animal {
	private int firePower;
	private double wingSpan;

	public Dragon(String newName, int newAge, double newWeight, int newFirePower, double newWingSpan) {
		super(newName, newAge, newWeight);
		this.firePower = newFirePower;
		this.wingSpan = newWingSpan;
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

	public int getFirePower() {
		return this.firePower;
	}

	public double getWingSpan() {
		return this.wingSpan;
	}
}