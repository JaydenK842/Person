import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    Product p1;

    @BeforeEach
    void setUp() {
        p1 = new Product("Items", "Multiple items", "00000A", 19.99);
    }

    @Test
    void setName() {
        p1.setName("Other");
        assertEquals("Other", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Very valuable");
        assertEquals("Very valuable", p1.getDescription());
    }

    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setCost() {
        p1.setCost(9.99);
        assertEquals(9.99, p1.getCost());
    }
}
