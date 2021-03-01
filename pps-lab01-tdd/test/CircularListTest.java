import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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


    @Test
    void testNext() {
        circularListImpl.add(1);
        circularListImpl.add(2);
        circularListImpl.add(3);
        assertEquals(2,circularListImpl.next().get());
        assertEquals(3,circularListImpl.next().get());
        assertEquals(1,circularListImpl.next().get());
        assertEquals(2,circularListImpl.next().get());
    }

    @Test
    void testNextEmpty() {
        assertEquals(Optional.empty(),circularListImpl.next());
    }

    @Test
    void testPrevious() {
        circularListImpl.add(1);
        circularListImpl.add(2);
        circularListImpl.add(3);
        assertEquals(3,circularListImpl.previous().get());
        assertEquals(2,circularListImpl.previous().get());
        assertEquals(1,circularListImpl.previous().get());
        assertEquals(3,circularListImpl.previous().get());
    }

    @Test
    void testPreviousEmpty() {
        assertEquals(Optional.empty(),circularListImpl.previous());
    }

    @Test
    void testReset() {
        assertTrue(circularListImpl.isEmpty());
        assertEquals(0,circularListImpl.size());
        circularListImpl.reset();
        assertTrue(circularListImpl.isEmpty());
        assertEquals(0,circularListImpl.size());
        circularListImpl.add(1);
        circularListImpl.add(2);
        circularListImpl.add(3);
        circularListImpl.reset();
        assertEquals(2, circularListImpl.next().get());
        circularListImpl.reset();
        assertEquals(2, circularListImpl.next().get());
    }
}
