package main;

public class CreditCard extends PaymentMethod{
	public void processPayment(double amount) {
		System.out.println(holder + " paid " + amount + " with credit card!");
	}

	public void refund(double amount) {
		System.out.println(holder + " received a refund of " + amount + "by CreditCard!");
	}
}