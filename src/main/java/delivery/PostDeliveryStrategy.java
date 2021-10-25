package delivery;

import delivery.Delivery;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public void deliver() {
        System.out.println("flowers were delivered with post service");
    }
}
