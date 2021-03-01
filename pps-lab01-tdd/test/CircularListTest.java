import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularListImpl circularListImpl;

    @BeforeEach
    void beforeEach(){
        circularListImpl = new CircularListImpl();
    }

    @Test
    void testAddElement() {
        circularListImpl.add(3);
    }

    @Test
    void testSize() {
        assertEquals(circularListImpl.size(), 0);
        for(int i=1;i<10;i++) {
            circularListImpl.add(i);
            assertEquals(i, circularListImpl.size());
        }
    }


}
