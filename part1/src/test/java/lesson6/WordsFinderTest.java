package lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 17:46
 * @project InnopolisUniversity
 */
class WordsFinderTest {
    File input;
    File output;

    @BeforeEach
    void setUp() {
        input = new File("src/main/java/lesson6/input");
        output = new File("src/main/java/lesson6/output");
    }

    @Test
    void readWords() throws IOException {
        Set<String> set = WordsFinder.readWords(input);
        assertNotNull(set);
        set.forEach(System.out::println);
    }

    @Test
    void saveToFile() throws IOException {
        WordsFinder.readWords(input);
        assertTrue(WordsFinder.saveToFile(input, output));
        WordsFinder.readWords(input);
    }
}