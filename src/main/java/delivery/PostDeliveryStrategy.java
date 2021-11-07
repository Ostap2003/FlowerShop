package delivery;

import delivery.Delivery;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public String deliver() {
        return "Post delivery";
    }
}
