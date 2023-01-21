import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1;

    @BeforeEach
    void setUp() {
        p1 = new Person("Jayden", "Knight", "00000A", "Mr.", 2006);
    }

    @Test
    void setFirstname() {
        p1.setFirstname("Nick");
        assertEquals("Nick", p1.getFirstname());
    }

    @Test
    void setLastName() {
        p1.setLastName("Wyoming");
        assertEquals("Wyoming", p1.getLastName());
    }

    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(2010);
        assertEquals(2010, p1.getYOB());
    }
}