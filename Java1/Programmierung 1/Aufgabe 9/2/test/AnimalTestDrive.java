package test;

import java.util.ArrayList;
import main.Animal;
import main.Dog;
import main.Cat;
import main.Dragon;
import main.RoboDog;
import main.Lion;
import main.Wolf;

public class AnimalTestDrive {
	public static void main(String[] args) {
		Cat cat = new Cat("Carlo", 9, 10.3, "Toy mouse");
		Dog dog = new Dog("Buddy", 12, 7.5, "Chihuahua");
		Lion lion = new Lion("Simba" , 20, 100, 86);
		Wolf wolf = new Wolf("Snow", 5, 3.9);
		Dragon dragon = new Dragon("Smaug", 150, 29873.3, 300, 20);
		RoboDog robo = new RoboDog("R2D2", true, 50);

		ArrayList<Animal> animals = new ArrayList<>(5);
		animals.add(cat);
		animals.add(dog);
		animals.add(lion);
		animals.add(wolf);
		animals.add(dragon);

		//Test 1
		System.out.println();
		System.out.println(" # Test 1: getter");
		System.out.println("Cat name: " + cat.getName() + " - Dog name: " + dog.getName());
		System.out.println("Lion name: " + lion.getName() + " - Wolf name: " + wolf.getName());
		System.out.println("Dragon name: " + dragon.getName() + " - RoboDog model: " + robo.getModel());
		System.out.println("Is " + robo.getModel() + " charged? - Answer: " + robo.getCharged());
		System.out.println();

		//Test 2
		System.out.println(" # Test 6: new instance variables (getter)");
		System.out.println("Dog: " + dog.getBreed() + " - Cat: " + cat.getFavoriteToy());
		System.out.println("Lion " + lion.getPrideSize() + " - Dragon: " + dragon.getFirePower() + ", " + dragon.getWingSpan());
		System.out.println("Robo: " + robo.getBatteryLife());
		System.out.println();
	}
}