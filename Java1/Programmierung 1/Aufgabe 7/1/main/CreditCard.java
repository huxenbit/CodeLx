package main;

public class CreditCard extends PaymentMethod{

	@Override
	public void processPayment(double amount) {
		System.out.println(getHolder() + " paid " + amount + " with credit card!");
	}
}