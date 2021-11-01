public class RibbonDecorator extends ItemDecorator {
    private Item item;

    public RibbonDecorator(Item i){
        this.item = i;
    }

    public double getPrice(){
        return item.getPrice() + 40;
    }

    public String getDescription(){
        return item.getDescription() + "[Ribbon]";
    }
}
