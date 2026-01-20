package main;

public class Wolf extends Canine {
	@Override
	public void makeSound() {
		System.out.println(getName() + " howls.");
	}
}