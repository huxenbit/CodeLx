package main;

public class GooglePay extends PaymentMethod {
	public void processPayment(double amount) {
		System.out.println(holder + " paid " + amount + " with GooglePay!");
	}

	public void refund(double amount) {
		System.out.println(holder + " received a refund of " + amount + "via GooglePay!");
	}
}