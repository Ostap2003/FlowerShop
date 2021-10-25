package paying_strategies;

import paying_strategies.Payment;

public class CreditCardPaymentStrategy implements Payment {

    @Override
    public void payment() {
        System.out.println("Paid with credit card!");
    }
}
