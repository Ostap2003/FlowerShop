public class PaperDecorator extends ItemDecorator {
    private Item item;

    public PaperDecorator(Item i){
        this.item = i;
    }

    public double getPrice(){
        return item.getPrice() + 13;
    }

    public String getDescription(){
        return item.getDescription() + "[Paper]";
    }
}
