package main;

public class Lion extends Feline {
	private int prideSize;

	public int getPrideSize() {
		return this.prideSize;
	}

	public void setPrideSize(int newPrideSize) {
		if (newPrideSize > 0) {
			this.prideSize = newPrideSize;
		}
	}

	@Override
	public void makeSound() {
		if (getPrideSize() >= 51) {
			System.out.println(getName() + " roars.");
		} else if (getPrideSize() <= 50) {
			System.out.println(getName() + " meows, but like a lion.");
		}
	}
}