import Order.Order;
import User.User;
import User.Sender;
import User.Reciever;

import Flower.*;
import delivery.*;
import paying_strategies.*;
import db.Connection;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
//        Flower flower = new Flower(FlowerType.TULIP);
//        flower.setColor(new int[]{123, 3, 4});
//        flower.setSepalLen(5.3);
//        flower.setPrice(23.45);
//
//        System.out.println(flower + "\n");
//
//        Inventory inventory = new Inventory();
//        inventory.fillInventory();
//
//        Store store = new Store(inventory);
//        ArrayList<Flower> result = store.search(FlowerType.ROSE, null, 0);
//
//        System.out.println(result.toString());



        // ------ CHECK INVENTORY GENERATION -----
//        Flower[] flowers = inventory.getInventory();
//
//        for (Flower f: flowers){
//            System.out.println(f);
//            System.out.println(f.getFlowerType() == FlowerType.CHAMOMILE);
//        }
//        Flower f = new Flower(FlowerType.ROSE);
//        f.setPrice(10);
//        FlowerPack pack = new FlowerPack(f, 10);
//
//
//        Item item = new FlowerBucket();
//        ((FlowerBucket) item).addPack(pack);
//
//        item = new RibbonDecorator(item);
//        item = new BasketDecorator(item);
//        item = new PaperDecorator(item);
//
//        double pr = item.getPrice();
//        String info = item.getDescription();
//
//        System.out.println(pr);
//        System.out.println(info);


//        // CHECK ORDER
        Payment payment = new PayPalPaymentStrategy();
        Delivery delivery = new PostDeliveryStrategy();

//        Order order = new Order();
        Order order = Order.quickOrder(payment, delivery);
        User user = new Sender(order);
        User user2 = new Reciever(order);

        Flower flower;
        FlowerPack pack;
        Item bucket;

        flower = new Flower(FlowerType.ROSE);
        flower.setPrice(10);
        pack = new FlowerPack(flower, 10);
        bucket = new FlowerBucket();
        ((FlowerBucket) bucket).addPack(pack);

        Flower flower2;
        FlowerPack pack2;
        Item bucket2;

        flower2 = new Flower(FlowerType.TULIP);
        flower2.setPrice(50);
        pack2 = new FlowerPack(flower2, 10);
        bucket2 = new FlowerBucket();
        ((FlowerBucket) bucket2).addPack(pack2);

        // apply decorators
        bucket = new PaperDecorator(bucket);
        bucket2 = new RibbonDecorator(bucket2);
        bucket2 = new BasketDecorator(bucket2);

        // add items to order
        order.addItem(bucket);
        order.addItem(bucket2);

        // add users
        order.addUser(user);
        order.addUser(user2);

//        Payment payment = new PayPalPaymentStrategy();
//        Delivery delivery = new PostDeliveryStrategy();
//        order.setPayment(payment);
//        order.setDelivery(delivery);

        order.processOrder();

        System.out.println(user.getOrderSate());
    }
}

