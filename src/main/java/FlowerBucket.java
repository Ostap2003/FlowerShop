import java.util.ArrayList;

public class FlowerBucket {
    // add flower pack
    // get price

    private ArrayList<FlowerPack> flowerPacks = new ArrayList<FlowerPack>();

    public void addPack(FlowerPack pack){
        flowerPacks.add(pack);
    }

    public ArrayList<FlowerPack> GetBucket(){
        return flowerPacks;
    }

    public double getPrice(){
        double price = 0;
        for (int i = 0; i < flowerPacks.size(); i++){
            price += flowerPacks.get(i).getPrice();
        }
        return price;
    }
}
