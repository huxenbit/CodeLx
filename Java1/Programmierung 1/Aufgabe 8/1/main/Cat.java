package main;

public class Cat extends Feline implements Pet{
	private String favoriteToy;

	public String getFavoriteToy() {
		return this.favoriteToy;
	}

	public void setFavoriteToy(String newFavoriteToy) {
		if (newFavoriteToy != null) {
			newFavoriteToy = newFavoriteToy.trim();
			if (!newFavoriteToy.isEmpty()) {
				this.favoriteToy = newFavoriteToy;
			}
		}
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
}