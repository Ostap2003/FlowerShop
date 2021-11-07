package Order;

import Flower.*;
import User.*;
import delivery.*;
import paying_strategies.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    private Flower flower;
    private FlowerPack pack;
    private Item bucket;

    private Flower flower2;
    private FlowerPack pack2;
    private Item bucket2;

    private User user;
    private User user2;

    private Payment payment;
    private Delivery delivery;

    @BeforeEach
    void setUp() {
        // initialize order
        order = new Order();

        // initialize 1st bucket
        flower = new Flower(FlowerType.ROSE);
        flower.setPrice(10);
        pack = new FlowerPack(flower, 10);
        bucket = new FlowerBucket();
        ((FlowerBucket) bucket).addPack(pack);

        // initialize 2nd bucket
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

        // initialize users and add them to order
        user = new Sender(order);
        user2 = new Reciever(order);
        order.addUser(user);
        order.addUser(user2);

        // set payment and delivery
        payment = new PayPalPaymentStrategy();
        delivery = new PostDeliveryStrategy();
        order.setDelivery(delivery);
        order.setPayment(payment);
    }

    @Test
    void calculateTotalPrice() {
        assertEquals(657, order.calculateTotalPrice());
    }

    @Test
    void notifyUsers() {
        order.notifyUsers();
        String expected = "DELIVERY:Post delivery\n" +
                "PAYMENT:Payed with PayPal\n" +
                "Bucket+[Paper]\n" +
                "PRICE:113.0\n" +
                "Bucket+[Ribbon][Basket]\n" +
                "PRICE:544.0\n" +
                "\n" +
                "TOTAL PRICE:657.0";
        assertEquals(user.getOrderSate(), expected);
        assertEquals(user2.getOrderSate(), expected);
    }

    @Test
    void order() {
        String expected = "DELIVERY:Post delivery\n" +
                "PAYMENT:Payed with PayPal\n" +
                "Bucket+[Paper]\n" +
                "PRICE:113.0\n" +
                "Bucket+[Ribbon][Basket]\n" +
                "PRICE:544.0\n" +
                "\n" +
                "TOTAL PRICE:657.0";

        assertEquals(expected, order.order());
    }

    @Test
    void quickOrder() {
        Order order = Order.quickOrder(payment, delivery);
        User newUser = new Reciever(order);

        order.addUser(newUser);
        order.addItem(bucket);
        assertEquals(113, order.calculateTotalPrice());

        String expected = "DELIVERY:Post delivery\n" +
                "PAYMENT:Payed with PayPal\n" +
                "Bucket+[Paper]\n" +
                "PRICE:113.0\n" +
                "\n" +
                "TOTAL PRICE:113.0";

        assertEquals(order.order(), expected);
        order.processOrder();
        assertEquals(newUser.getOrderSate(), expected);
    }
}