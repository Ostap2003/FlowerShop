package Order;

import User.User;
import Flower.Item;
import delivery.*;
import paying_strategies.*;

import java.util.ArrayList;

public class Order {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private Payment payment;
    private Delivery delivery;

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void processOrder(){
        this.notifyUsers();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void notifyUsers(){
        for (User user : users){
            user.update();
        }
    }

    public String order(){
        String itemInfo = "";
        for (Item item : items){
            itemInfo += item.getDescription() + "\n";
            itemInfo += "PRICE:" + item.getPrice() + "\n";
        }
        return "DELIVERY:" + delivery.deliver() + "\n" + "PAYMENT:" + payment.payment() + "\n" + itemInfo + "\n" +
                "TOTAL PRICE:" + this.calculateTotalPrice();
    }

    public static Order quickOrder(Payment payment, Delivery delivery){
        Order order = new Order();
        order.setPayment(payment);
        order.setDelivery(delivery);
        return order;
    }
}
