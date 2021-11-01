import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorBucketTest {
    private Flower flower;
    private FlowerPack pack;
    private Item bucket;

    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.ROSE);
        flower.setPrice(10);
        pack = new FlowerPack(flower, 10);
        bucket = new FlowerBucket();
        ((FlowerBucket) bucket).addPack(pack);
    }

    @Test
    void testDecorators(){
        bucket = new PaperDecorator(bucket);
        assertEquals(113, bucket.getPrice());
        assertEquals("Bucket+[Paper]", bucket.getDescription());

        bucket = new BasketDecorator(bucket);
        assertEquals(117, bucket.getPrice());
        assertEquals("Bucket+[Paper][Basket]", bucket.getDescription());

        bucket = new RibbonDecorator(bucket);
        assertEquals(157, bucket.getPrice());
        assertEquals("Bucket+[Paper][Basket][Ribbon]", bucket.getDescription());
    }
}
