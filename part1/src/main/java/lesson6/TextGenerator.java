package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 18:53
 * @project InnopolisUniversity
 */
public class TextGenerator {

    public static void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        for (int i = 0; i < n; i++) {
            byte[] text = generateTextWithProbability(words, probability).substring(0, size).getBytes();
            Files.write(Paths.get(path + i), text, StandardOpenOption.CREATE);
        }
    }

    /**
     * Генерирует текст
     * @return string
     */
    public static String generateText() {
        Random random = new Random();
        int len  = random.ints(5, 10).findFirst().getAsInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(generateParagraph());
        }
        return stringBuilder.toString();
    }

    /**
     * Генерирует текст
     * @return string
     */
    public static String generateTextWithProbability(String[] w, int probability) {
        Random random = new Random();
        int len  = random.ints(5, 10).findFirst().getAsInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(generateParagraphWithProbability(w, probability));
        }
        return stringBuilder.toString();
    }

    /**
     * Генерирует абзацы, завершающиеся переносом строки и каретки
     * @return string
     */
    public static String generateParagraph() {
        Random random = new Random();
        int len = random.ints(1, 21).findFirst().getAsInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(generateProposal());
        }
        return stringBuilder.append("\n\r").toString();
    }

    /**
     * Генерирует абзацы, завершающиеся переносом строки и каретки
     * @return string
     */
    private static String generateParagraphWithProbability(String[] w, int probability) {
        Random random = new Random();
        int len = random.ints(1, 21).findFirst().getAsInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(generateProposalWithProbability(w, probability));
        }
        return stringBuilder.append("\n\r").toString();
    }

    /**
     * Генерирует предложение с диапозоном слов 1-15, произвольными запятыми и конечными знаками [.?!]
     * @return String
     */
    public static String generateProposal() {
        Random random = new Random();
        int length = random.ints(1, 16).findFirst().getAsInt();

        StringBuilder stringBuffer = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            String word = generateWord();

            if (i == 0) {
                word = firstLetterToUpperCase(word);
            }
            if (i == length-1) {
                stringBuffer.append(word).append(generatePunctuationMarks());
            }
            else {
                stringBuffer.append(word).append(" ");
            }
        }

        return stringBuffer.toString();
    }

    /**
     * Генерирует предложение с диапозоном слов 1-15, произвольными запятыми и конечными знаками [.?!]
     * и вероятность вхождения слова
     * @return String
     */
    private static String generateProposalWithProbability(String[] wordsWithProbability, int probability) {
        Random random = new Random();
        int length = random.ints(1, 16).findFirst().getAsInt();

        int rndProbability = random.nextInt(100);

        int rndWord = random.ints(1, wordsWithProbability.length).findFirst().getAsInt();

        StringBuilder stringBuffer = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            String word = generateWord();
            if (rndProbability <= probability)
                word = wordsWithProbability[rndWord];
            if (i == 0) {
                word = firstLetterToUpperCase(word);
            }
            if (i == length-1) {
                stringBuffer.append(word).append(generatePunctuationMarks());
            }
            else {
                stringBuffer.append(word).append(" ");
            }
        }

        return stringBuffer.toString();
    }

    /**
     * Генерирует слово длиной 1-15 символов
     * @return слово
     */
    public static String generateWord() {
        Random random = new Random();

        int length = random.ints(1, 16).findFirst().getAsInt();

        StringBuilder stringBuffer = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // принимаем случайное значение от 97 до 122
            int nextRandomChar = random.ints(97, 123).findFirst().getAsInt();
            stringBuffer.append((char) nextRandomChar);

        }
        return stringBuffer.toString();

    }

    public static String firstLetterToUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String generatePunctuationMarks() {
        Random r = new Random();

        String[] marks = {".", "!", "?"};

        return marks[r.ints(0,3).findFirst().getAsInt()] + " ";
    }
}
