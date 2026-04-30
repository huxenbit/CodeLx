package main;

public abstract class Animal {
	private String name;
	private int age;
	private double weight;

	public Animal(String newName, int newAge, double newWeight) {
		this.name = newName;
		this.age = newAge;
		this.weight = newWeight;
	}

	public void eat() {
		System.out.println(getName() + " is eating.");
	}

	public void move() {
		System.out.println(getName() + " moves.");
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public double getWeight() {
		return this.weight;
	}

	public abstract void makeSound();
}