import Flower.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower flower;


    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.TULIP);
        flower.setPrice(40.3);
        flower.setSepalLen(15.1);
        flower.setColor(new int[]{233, 5, 3});
    }

    @Test
    void getFlowerType() {
        assertEquals(FlowerType.TULIP, flower.getFlowerType());
    }

    @Test
    void setPrice() {
        flower.setPrice(20.3);
        assertEquals(20.3, flower.getPrice());
    }

    @Test
    void setSepalLen() {
        flower.setSepalLen(10.4);
        assertEquals(10.4, flower.getSepalLen());
    }

    @Test
    void getSepalLen() {
        assertEquals(15.1, flower.getSepalLen());
    }


    @Test
    void getPrice() {
        assertEquals(40.3, flower.getPrice());
    }

    @Test
    void testToString() {
        assertEquals("TULIP{color:[233, 5, 3], sepallen:15.1, price:40.3}", flower.toString());
    }
}