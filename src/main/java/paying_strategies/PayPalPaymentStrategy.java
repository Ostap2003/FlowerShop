package paying_strategies;

import paying_strategies.Payment;

public class PayPalPaymentStrategy implements Payment {

    @Override
    public String payment() {
        return "Payed with PayPal";
    }
}
