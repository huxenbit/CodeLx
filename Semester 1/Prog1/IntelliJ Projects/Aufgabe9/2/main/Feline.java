package main;

public abstract class Feline extends Animal {
	@Override
	public void eat() {
		System.out.println(getName() + " is eating.");
		System.out.println(getName() + " licks its paws after eating.");
	}

	public Feline(String newName, int newAge, double newWeight) {
		super(newName, newAge, newWeight);
	}
}