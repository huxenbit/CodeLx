package main;

public class PayPal extends PaymentMethod {
	public void processPayment(double amount) {
		System.out.println(holder + " paid " + amount + " with PayPal!");
	}

	public void refund(double amount) {
		System.out.println(holder + " received a refund of " + amount + "via PayPal!");
	}
}