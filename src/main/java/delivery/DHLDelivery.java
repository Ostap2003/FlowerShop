package delivery;

import delivery.Delivery;

public class DHLDelivery implements Delivery {
    @Override
    public String deliver() {
        return "DHL delivery";
    }
}
