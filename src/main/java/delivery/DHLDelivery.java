package delivery;

import delivery.Delivery;

public class DHLDelivery implements Delivery {
    @Override
    public void deliver() {
        System.out.println("flowers were delivered with DHL");
    }
}
