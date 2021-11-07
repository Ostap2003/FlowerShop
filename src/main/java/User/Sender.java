package User;

import User.User;
import Order.Order;

import java.util.Random;

public class Sender implements User {
    private int id;
    private Order order;
    private String orderState;

    public Sender(Order order){
        Random rand = new Random();
        this.id = rand.nextInt(20000);
        this.order = order;
    }

    public void update(){
        orderState = this.order.order();
    }

    @Override
    public String getOrderSate() {
        return orderState;
    }
}
