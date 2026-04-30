package main;

public class PaymentMethod {
	String holder;

	public String getHolder() {
		return holder;
	}

	public void setHolder(String newHolder) {
		holder = newHolder;
	}

	public void processPayment(double amount) {
		System.out.println(holder + " paid " + amount + "!");
	}

	public void refund(double amount) {
		System.out.println(holder + " received a refund of " + amount + "!");
	}
}