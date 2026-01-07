package main;

public abstract class Canine extends Animal {
	@Override
	public void eat() {
		System.out.println(getName() + " is eating.");
		System.out.println(getName() + " howls after eating.");
	}

	public Canine(String newName, int newAge, double newWeight) {
		super(newName, newAge, newWeight);
	}
}