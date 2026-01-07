package main;

public class ElectricCar extends Car {
	int batteryCapacity; //KWH

	public ElectricCar(String newBrand, String newModel, String newColor, int newMaxSpeed, int newBatteryCapacity) {
		super(newBrand, newModel, newColor, newMaxSpeed);
		this.batteryCapacity = newBatteryCapacity;
	}

	public ElectricCar(String newBrand, String newModel) {
		super(newBrand, newModel);
		this.batteryCapacity = 60;
	}

	public void printInfo() {
		System.out.println(	"\nBrand: " + this.brand + 
							"\nModel: " + this.model + 
							"\nColor: " + this.color + 
							"\nMax Speed: " + this.maxSpeed + " km/h" + 
							"\nBattery Capacity: " + this.batteryCapacity);
	}
}