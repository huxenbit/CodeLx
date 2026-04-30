package main;

public class PaymentMethod {
	private String holder;

	public String getHolder() {
		return holder;
	}

	public void setHolder(String newHolder) {
		holder = newHolder;
	}

	public void processPayment(double amount) {
		System.out.println(holder + " paid " + amount + "!");
	}
}