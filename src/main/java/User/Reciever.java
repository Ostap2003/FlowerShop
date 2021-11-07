package User;

import Order.Order;

import java.util.Random;

public class Reciever implements User {
    private int id;
    private Order order;
    private String orderState;

    public Reciever(Order order){
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
