import java.util.Arrays;

public class Flower {
    private double price;
    private double sepalLen;
    private int[] color;
    private FlowerType flower;

    public Flower(FlowerType type) {
        this.flower = type;
    }

    public FlowerType getFlowerType(){
        return flower;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setSepalLen(double len){
        this.sepalLen = len;
    }

    public double getSepalLen(){
        return sepalLen;
    }

    public void setColor(int[] color){
        this.color = Arrays.copyOf(color, color.length);
    }

    public int[] getColor(){
        return color;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return flower + "{color:" + Arrays.toString(color) + ", sepallen:" + sepalLen + ", price:" + price + "}";
    }
}
