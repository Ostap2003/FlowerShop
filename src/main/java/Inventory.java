import Flower.*;

import java.util.ArrayList;
import java.util.Random;

public class Inventory {
    private Random rand = new Random();
    private int inventoryCapacity = 20;
    private FlowerType[] flowerTypes = {FlowerType.TULIP, FlowerType.CHAMOMILE, FlowerType.ROSE};
    private Flower[] flowers = new Flower[inventoryCapacity];

    public Flower[] getInventory(){
        return flowers;
    }

    public void fillInventory(){
        // randomly generate inventory
        for (int i = 0; i < inventoryCapacity; i++){
            // flowerType, color, sepallen

            int[] colors = new int[3];
            for (int c = 0; c < 3; c++){
                colors[c] = rand.nextInt(255);
            }
            double sepalLen = rand.nextInt(30 - 10) + 10;

            // create flower instance
            Flower newFlower = new Flower(flowerTypes[rand.nextInt(3)]);
            newFlower.setColor(colors);
            newFlower.setSepalLen(sepalLen);

            // add flower instance to inventory
            flowers[i] = newFlower;
        }
    }


    public ArrayList<Flower> search(FlowerType flowerType, int[] color, double sepallen){
        ArrayList<Flower> searchResult = new ArrayList<Flower>();

        if (!flowerType.equals("")) {
            searchByType(searchResult, flowerType);
        }

        if (color != null) {
            searchByColor(searchResult, color);
        }

        if (sepallen != 0) {
            searchBySepalLen(searchResult, sepallen);
        }

        return searchResult;
    }

    private void searchByType(ArrayList<Flower> srchResult, FlowerType fType){
        for (Flower flower : flowers){
//            String currfType = flower.getFlowerType().toString();
//            if (currfType.toLowerCase().equals(flowerType)){
            if (fType == flower.getFlowerType()){
                srchResult.add(flower);
            }
            }
        }

    private void searchByColor(ArrayList<Flower> srchResult, int[] color){
        for (Flower flower : flowers){
            if (flower.getColor() == color){
                srchResult.add(flower);
            }
        }
    }

    private void searchBySepalLen(ArrayList<Flower> srchResult, double sepallen){
        for (Flower flower : flowers){
            if (flower.getSepalLen() == sepallen){
                srchResult.add(flower);
            }
        }
    }
}
