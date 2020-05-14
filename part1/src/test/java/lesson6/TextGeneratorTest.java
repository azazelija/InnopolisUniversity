package lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 19:07
 * @project InnopolisUniversity
 */
class TextGeneratorTest {

    @Test
    void generateText() {
        for (int i = 0; i < 3; i++) {
            System.out.println(TextGenerator.generateText());
        }
    }

    @Test
    void generateWord() {
        for (int i = 0; i < 10; i++) {
            System.out.println(TextGenerator.generateWord());
        }
    }

    @Test
    void generateProposal() {
        for (int i = 0; i < 10; i++) {
            System.out.println(TextGenerator.generateProposal());
        }
    }

    @Test
    void generateParagraph() {
        for (int i = 0; i < 10; i++) {
            System.out.println(TextGenerator.generateParagraph());
        }
    }

    @Test
    void firstLetterToUpperCase() {
        assertEquals("A", TextGenerator.firstLetterToUpperCase("a"));
        assertEquals("Anna", TextGenerator.firstLetterToUpperCase("anna"));
    }
}