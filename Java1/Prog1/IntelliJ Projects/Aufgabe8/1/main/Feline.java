package main;

public abstract class Feline extends Animal {
	@Override
	public void eat() {
		System.out.println(getName() + " is eating.");
		System.out.println(getName() + " licks its paws after eating.");
	}
}