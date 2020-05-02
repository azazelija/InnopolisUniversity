package lesson3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 02/05/2020 - 21:46
 * @project InnopolisUniversity
 */
class MathBoxTest {

    MathBox<Number> mathBox;
    List<Number> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3.5);

        mathBox = new MathBox<>(list);
    }

    @Test
    void summator() {
        assertEquals(6.5, mathBox.summator());
    }

    @Test
    void splitter() {
        assertEquals(mathBox.getCollection(), mathBox.splitter(1));
    }

    @Test
    void deleteIntegerValue() {
        assertTrue(mathBox.deleteIntegerValue());
    }
}