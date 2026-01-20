package main;

public class Car {
	String brand;
	String model;
	String color;
	int maxSpeed; //KMH

	public Car(String newBrand, String newModel, String newColor, int newMaxSpeed) {
		this.brand = newBrand;
		this.model = newModel;
		this.color = newColor;
		this.maxSpeed = newMaxSpeed;
	}

	public Car(String newBrand, String newModel) {
		this.brand = newBrand;
		this.model = newModel;
		this.color = "Black";
		this.maxSpeed = 180;
	}

	public void printInfo() {
		System.out.println(	"\nBrand: " + this.brand + 
							"\nModel: " + this.model + 
							"\nColor: " + this.color + 
							"\nMax Speed: " + this.maxSpeed + " km/h");
	}
}