package main;

public class PayPal extends PaymentMethod {

	@Override
	public void processPayment(double amount) {
		System.out.println(super.getHolder() + " paid " + amount + " with PayPal!");
	}
}