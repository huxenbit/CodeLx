package test;

import main.CreditCard;

public class CreditCardTestDrive {
	public static void main(String[] args) {
		CreditCard creditCard = new CreditCard();
		creditCard.setHolder("Gianluca");
		creditCard.payWithCreditCard(100.0);
	}
}