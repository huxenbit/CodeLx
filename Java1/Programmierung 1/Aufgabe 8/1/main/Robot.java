package main;

public abstract class Robot {
	private String model;

	public String getModel() {
		return this.model;
	}

	public void setModel(String newModel) {
		if (newModel != null) {
			newModel = newModel.trim();
			if (!newModel.isEmpty()) {
				this.model = newModel;
			}
		}
	}

	public abstract void performTask();
}