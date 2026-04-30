package test;

import main.Car;
import main.ElectricCar;


public class CarTestDrive {
	public static void main(String[] args) {
		Car car1 = new Car("Ferrari", "911", "Red", 320);
		Car car2 = new Car("Fiat", "Punto");
		ElectricCar eCar = new ElectricCar("Peugeot", "207", "White", 180, 45);
		ElectricCar eCar2 = new ElectricCar("Lamborghini", "Gallardo");

		System.out.println("\n1.1 und 1.2: ");
		car1.printInfo(); //alle attribute
		car2.printInfo(); //nur brand und model

		System.out.println("\n1.3: ");
		eCar.printInfo(); //alle attribute
		eCar2.printInfo(); //nur brand und model


	}
}