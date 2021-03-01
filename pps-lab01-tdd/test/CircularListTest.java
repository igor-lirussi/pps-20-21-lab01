import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    void addElement() {
        circularListImpl.add(3);
    }

}
