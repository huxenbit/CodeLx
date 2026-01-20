package main;

public abstract class Canine extends Animal {
	@Override
	public void eat() {
		System.out.println(getName() + " is eating.");
		System.out.println(getName() + " howls after eating.");
	}
}