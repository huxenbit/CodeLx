package main;

public class Lion extends Feline {
	private int prideSize;

	public Lion(String newName, int newAge, double newWeight, int newPride) {
		super(newName, newAge, newWeight);
		this.prideSize = newPride;
	}

	@Override
	public void makeSound() {
		if (getPrideSize() >= 51) {
			System.out.println(getName() + " roars.");
		} else if (getPrideSize() <= 50) {
			System.out.println(getName() + " meows, but like a lion.");
		}
	}

	public int getPrideSize() {
		return this.prideSize;
	}
}