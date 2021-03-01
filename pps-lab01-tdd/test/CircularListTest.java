import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        for(int elementNumber=1;elementNumber<10;elementNumber++) {
            circularListImpl.add(elementNumber);
            assertEquals(elementNumber, circularListImpl.size());
        }
    }

    @Test
    void testIsEmpty() {
        assertTrue(circularListImpl.isEmpty());
        circularListImpl.add(7);
        assertFalse(circularListImpl.isEmpty());
    }

    
}
