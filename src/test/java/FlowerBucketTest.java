import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {
    private Flower flower;
    private FlowerPack pack;
    private FlowerBucket bucket;

    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.ROSE);
        flower.setPrice(23);
        pack = new FlowerPack(flower, 10);
        bucket = new FlowerBucket();
        bucket.addPack(pack);
    }

    @Test
    void addPack() {
        bucket.addPack(pack);
    }

    @Test
    void getPrice() {
        assertEquals(230, bucket.getPrice());
    }
}