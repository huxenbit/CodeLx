package main;

public class GooglePay extends PaymentMethod {

	@Override
	public void processPayment(double amount) {
		System.out.println(getHolder() + " paid " + amount + " with GooglePay!");
	}
}