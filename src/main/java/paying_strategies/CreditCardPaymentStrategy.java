package paying_strategies;

import paying_strategies.Payment;

public class CreditCardPaymentStrategy implements Payment {

    @Override
    public String payment() {
        return "Paid with credit card";
    }
}
