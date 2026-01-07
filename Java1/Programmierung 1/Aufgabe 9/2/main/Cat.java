package main;

public class Cat extends Feline implements Pet{
	private String favoriteToy;

	public Cat(String newName, int newAge, double newWeight, String newToy) {
		super(newName, newAge, newWeight);
		this.favoriteToy = newToy;
	}

	@Override
	public void makeSound() {
		System.out.println(getName() + " meows.");
	}

	@Override
	public void play() {
		System.out.println(getName() + " is playing with a ball of yarn.");
	}

	public void hunt() {
		System.out.println(getName() + " is hunting mice!");
	}

	public String getFavoriteToy() {
		return this.favoriteToy;
	}
}