package main;

public abstract class Robot {
	private String model;

	public Robot(String newModel) {
		this.model = newModel;
	}

	public String getModel() {
		return this.model;
	}

	public abstract void performTask();
}