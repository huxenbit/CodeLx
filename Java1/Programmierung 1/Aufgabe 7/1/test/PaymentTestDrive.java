package test;

import java.util.ArrayList;
import main.CreditCard;
import main.PayPal;
import main.GooglePay;

public class PaymentTestDrive {
	public static void main(String[] args) {
		CreditCard creditCard = new CreditCard(); //Creating object
		PayPal payPal = new PayPal(); //Creating object
		GooglePay googlePay = new GooglePay();

		//Aufgabe 1.1
		System.out.println("Aufgabe 1.1");
		ArrayList<Object> paymentMethods = new ArrayList<Object>(2); //Creating array list
		paymentMethods.add(creditCard); //adding creditcard to array list
		paymentMethods.add(payPal); //adding paypal to array list

		//Extra-Aufgabe
		for (Object payM : paymentMethods) { //for each paymentMethod in paymentMethods-List
			if (payM instanceof CreditCard) { //if payM "is" CreditCard
				CreditCard cc = (CreditCard) payM; 
				cc.setHolder("Gianluca"); //set new holder
				cc.processPayment(100.0); //pay 100.0 money
			} else if (payM instanceof PayPal) { //if payM "is" PayPal
				PayPal pp = (PayPal) payM; 
				pp.setHolder("Lars"); //set new holder
				pp.processPayment(100.0); //pay 100.0 money
			}
		}


		//Aufgabe 1.2
		System.out.println();
		System.out.println("Aufgabe 1.2");
		System.out.println("Holder: " + payPal.getHolder()); //printing current holder
		payPal.processPayment(150.0); //paying 150.0 money
		System.out.println("Holder: " + creditCard.getHolder());
		creditCard.processPayment(150.0);

		googlePay.setHolder("Michael Jackson"); //setting new holder mj
		System.out.println("Holder: " + googlePay.getHolder());
		googlePay.processPayment(2000.0);
	}
}