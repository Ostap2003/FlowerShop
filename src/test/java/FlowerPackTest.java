import Flower.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {
    private FlowerPack pack;
    private Flower flower;

    @BeforeEach
    void setUp(){
        flower = new Flower(FlowerType.CHAMOMILE);
        flower.setPrice(30.9);
        pack = new FlowerPack(flower, 10);
    }

    @Test
    void getPrice() {
        assertEquals(309, pack.getPrice());
    }
}