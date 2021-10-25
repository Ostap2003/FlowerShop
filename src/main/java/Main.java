import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Flower flower = new Flower(FlowerType.TULIP);
        flower.setColor(new int[]{123, 3, 4});
        flower.setSepalLen(5.3);
        flower.setPrice(23.45);

        System.out.println(flower + "\n");

        Inventory inventory = new Inventory();
        inventory.fillInventory();

        Store store = new Store(inventory);
        ArrayList<Flower> result = store.search(FlowerType.ROSE, null, 0);

        System.out.println(result.toString());

        // ------ CHECK INVENTORY GENERATION -----
//        Flower[] flowers = inventory.getInventory();
//
//        for (Flower f: flowers){
//            System.out.println(f);
//            System.out.println(f.getFlowerType() == FlowerType.CHAMOMILE);
//        }
    }
}

