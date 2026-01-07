package main;

public abstract class Animal {
	private String name;
	private int age;
	private double weight;

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		if (newName != null) {
			newName = newName.trim();
			if (!newName.isEmpty()) {
				this.name = newName;
			}
		}
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int newAge) {
		if (newAge > 0) {
			age = newAge;
		}
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double newWeight) {
		if (newWeight > 0) {
			this.weight = newWeight;
		}
	}

	public void eat() {
		System.out.println(getName() + " is eating.");
	}

	public void move() {
		System.out.println(getName() + " moves.");
	}

	public abstract void makeSound();
}