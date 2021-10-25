public class FlowerPack {
    private Flower flower;
    private int flowerNum;

    public FlowerPack(Flower flower, int num){
        this.flowerNum = num;
        this.flower = flower;
    }

    public double getPrice(){
        return flower.getPrice() * flowerNum;
    }
}
