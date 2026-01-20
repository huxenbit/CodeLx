package main;

public class Dog extends Canine implements Pet {
	private String breed;

	public Dog(String newName, int newAge, double newWeight, String newBreed) {
		super(newName, newAge, newWeight);
		this.breed = newBreed;
	}


	@Override
	public void makeSound() {
		System.out.println(getName() + " barks.");
	}
	@Override
	public void play() {
		System.out.println(getName() + " is playing with a stick.");
	}

	public void guard() {
		System.out.println(getName() + " guards his owner.");
	}

	public String getBreed() {
		return this.breed;
	}
}