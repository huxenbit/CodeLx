package main;

public class Dog extends Canine implements Pet {
	private String breed;

	public String getBreed() {
		return this.breed;
	}

	public void setBreed(String newBreed) {
		if (newBreed != null) {
			newBreed = newBreed.trim();
			if (!newBreed.isEmpty()) {
				this.breed = newBreed;
			}
		}
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
}