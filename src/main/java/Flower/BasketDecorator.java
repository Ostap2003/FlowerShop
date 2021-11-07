package Flower;

public class BasketDecorator extends ItemDecorator {
    private Item item;

    public BasketDecorator(Item i){
        this.item = i;
    }

    public double getPrice(){
        return item.getPrice() + 4;
    }

    public String getDescription(){
        return item.getDescription() + "[Basket]";
    }
}
