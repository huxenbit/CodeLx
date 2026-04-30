package test;

import main.CreditCard;
import main.PayPal;
import main.GooglePay;
import main.PaymentMethod;

public class PaymentTestDrive {
	public static void main(String[] args) {
		CreditCard c = new CreditCard();
		PayPal p = new PayPal();
		GooglePay g = new GooglePay();

		java.util.ArrayList<PaymentMethod> paymentMethods = new java.util.ArrayList<PaymentMethod>(3);
		paymentMethods.add(c);
		paymentMethods.add(p);
		paymentMethods.add(g);

		for (PaymentMethod pm : paymentMethods) {
			pm.processPayment(100.0);
			pm.refund(100.0);
		}
	}
}