import Flower.*;

import java.util.ArrayList;

public class Store {
    private Inventory inventory;

    public Store(Inventory inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Flower> search(FlowerType flowerType, int[] color, double sepallen){
        return inventory.search(flowerType, color, sepallen);
    }
}
