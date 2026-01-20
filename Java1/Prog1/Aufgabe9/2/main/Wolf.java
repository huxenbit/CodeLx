package main;

public class Wolf extends Canine {
	@Override
	public void makeSound() {
		System.out.println(getName() + " howls.");
	}

	public Wolf(String newName, int newAge, double newWeight) {
		super(newName, newAge, newWeight);
	}
}