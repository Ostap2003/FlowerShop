import java.util.ArrayList;

public class FlowerBucket extends Item{
    private ArrayList<FlowerPack> flowerPacks = new ArrayList<FlowerPack>();

    public void addPack(FlowerPack pack){
        flowerPacks.add(pack);
    }

    public ArrayList<FlowerPack> GetBucket(){
        return flowerPacks;
    }

    public String getDescription(){
        return "Bucket+";
    }

    public double getPrice(){
        double price = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }
}
