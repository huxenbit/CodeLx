package test;

import main.PayPal;

public class PayPalTestDrive {
	public static void main(String[] args) {
		PayPal payPal = new PayPal();
		payPal.setHolder("Gianluca");
		payPal.payWithPayPal(100.0);
	}
}