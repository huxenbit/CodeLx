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
		Cat cat = new Cat();
		Dog dog = new Dog();
		Lion lion = new Lion();
		Wolf wolf = new Wolf();
		Dragon dragon = new Dragon();
		RoboDog robo = new RoboDog();

		ArrayList<Animal> animals = new ArrayList<>(5);
		animals.add(cat);
		animals.add(dog);
		animals.add(lion);
		animals.add(wolf);
		animals.add(dragon);

		//Test 1
		System.out.println();
		System.out.println(" # Test 1: Setter and getter");
		cat.setName("Carlo");
		dog.setName("Buddy");
		lion.setName("Simba");
		wolf.setName("Snow");
		dragon.setName("Smaug");
		robo.setModel("R2-D2");
		robo.setCharged(true);
		System.out.println("Cat name: " + cat.getName() + " - Dog name: " + dog.getName());
		System.out.println("Lion name: " + lion.getName() + " - Wolf name: " + wolf.getName());
		System.out.println("Dragon name: " + dragon.getName() + " - RoboDog model: " + robo.getModel());
		System.out.println("Is " + robo.getModel() + " charged? - Answer: " + robo.getCharged());
		System.out.println();

		//Test 2
		System.out.println(" # Test 2: eat()");
		for (Animal animal : animals) {
			animal.eat();
		}
		System.out.println();

		//Test 3
		System.out.println(" # Test 3: makeSound()");
		for (Animal animal : animals) {
			animal.makeSound();
		}
		System.out.println();

		//Test 4
		System.out.println(" # Test 4: play()");
		dog.play();
		cat.play();
		robo.play();
		System.out.println();

		//Test 5
		System.out.println(" # Test 5: performTask()");
		robo.performTask();
		System.out.println();
		robo.setCharged(false);
		robo.performTask();
		robo.play();
		System.out.println();

		//Test 6
		System.out.println(" # Test 6: new instance variables (setter and getter)");
		dog.setBreed("Chihuahua");
		cat.setFavoriteToy("Ball of Yarn");
		lion.setPrideSize(40);
		dragon.setFirePower(99);
		dragon.setWingSpan(20);
		robo.setBatteryLife(50);
		System.out.println("Dog: " + dog.getBreed() + " - Cat: " + cat.getFavoriteToy());
		System.out.println("Lion " + lion.getPrideSize() + " - Dragon: " + dragon.getFirePower() + ", " + dragon.getWingSpan());
		System.out.println("Robo: " + robo.getBatteryLife());
		System.out.println();

		//Test 7
		System.out.println(" # Test 7: methods");
		cat.hunt();
		dog.guard();
		System.out.println(lion.getName() + " prideSize: " + lion.getPrideSize());
		lion.makeSound();
		lion.setPrideSize(89);
		System.out.println(lion.getName() + " prideSize: " + lion.getPrideSize());
		lion.makeSound();
		dragon.breatheFire();
		dragon.fly();
		robo.recharge();
		robo.diagnostics();
		System.out.println();
	}
}