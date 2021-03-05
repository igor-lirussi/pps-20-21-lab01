import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void testNextStrategyEmpty() {
        assertEquals(Optional.empty(), circularListImpl.next(new EvenStrategy()));
        assertEquals(Optional.empty(), circularListImpl.next(new EqualsStrategy(3)));
        assertEquals(Optional.empty(), circularListImpl.next(new MultipleOfStrategy(3)));
    }
    @Test
    void testNextStrategyNotPresent() {
        for (int number = 0; number < 12; number++) {
            circularListImpl.add((number*2)+1);
        }
        assertEquals(Optional.empty(), circularListImpl.next(new EvenStrategy()));
        assertEquals(Optional.empty(), circularListImpl.next(new EqualsStrategy(25)));
        assertEquals(Optional.empty(), circularListImpl.next(new MultipleOfStrategy(25)));
    }

    @Test
    void testNextStrategy() {
        for (int number=0; number<12; number++ ) {
            circularListImpl.add(number);
        }
        assertEquals(2, circularListImpl.next(new EvenStrategy()).get() );
        assertEquals(4, circularListImpl.next(new EvenStrategy()).get() );
        assertEquals(6, circularListImpl.next(new EvenStrategy()).get() );

        assertEquals(6, circularListImpl.next(new EqualsStrategy(6)).get() );
        assertEquals(8, circularListImpl.next(new EqualsStrategy(8)).get() );
        assertEquals(11, circularListImpl.next(new EqualsStrategy(11)).get() );
        assertEquals(3, circularListImpl.next(new EqualsStrategy(3)).get() );


        assertEquals(6, circularListImpl.next(new MultipleOfStrategy(3)).get() );
        assertEquals(9, circularListImpl.next(new MultipleOfStrategy(3)).get() );
        assertEquals(0, circularListImpl.next(new MultipleOfStrategy(3)).get() );
        assertEquals(3, circularListImpl.next(new MultipleOfStrategy(3)).get() );
        assertEquals(4, circularListImpl.next(new MultipleOfStrategy(2)).get() );

    }

    @Test
    void testNextStrategyWithFactory() {
        for (int number=0; number<12; number++ ) {
            circularListImpl.add(number);
        }
        StrategyFactoryImpl strategyFactory = new StrategyFactoryImpl();

        assertEquals(2, circularListImpl.next(strategyFactory.createEvenStrategy()).get() );
        assertEquals(4, circularListImpl.next(strategyFactory.createEvenStrategy()).get() );
        assertEquals(6, circularListImpl.next(strategyFactory.createEvenStrategy()).get() );

        assertEquals(6, circularListImpl.next(strategyFactory.createEqualsStrategy(6)).get() );
        assertEquals(8, circularListImpl.next(strategyFactory.createEqualsStrategy(8)).get() );
        assertEquals(11, circularListImpl.next(strategyFactory.createEqualsStrategy(11)).get() );
        assertEquals(3, circularListImpl.next(strategyFactory.createEqualsStrategy(3)).get() );


        assertEquals(6, circularListImpl.next(strategyFactory.createMultipleOfStrategy(3)).get() );
        assertEquals(9, circularListImpl.next(strategyFactory.createMultipleOfStrategy(3)).get() );
        assertEquals(0, circularListImpl.next(strategyFactory.createMultipleOfStrategy(3)).get() );
        assertEquals(3, circularListImpl.next(strategyFactory.createMultipleOfStrategy(3)).get() );
        assertEquals(4, circularListImpl.next(strategyFactory.createMultipleOfStrategy(2)).get() );

    }

}
