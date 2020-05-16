package lesson6;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 18395435
 * @created_at 14/05/2020 - 17:06
 * @project InnopolisUniversity
 */
public class WordsFinder {

    private WordsFinder() {
    }

    /**
     * Считывает файл и возвращает уникальные слова в альфавитном порядке
     * @param input file
     * @return Set
     * @throws IOException
     */
    public static Set<String> readWords(File input) throws IOException {
        SortedSet<String> words = new TreeSet<>();

        Pattern pattern =
                Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String str;
            while ((str = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(str);

                while (matcher.find())
                    words.add(matcher.group().toLowerCase());
            }
        }
        return words;
    }

    /**
     * Считывает файл и сохраняет в указанный файл уникальные слова в альфавитном порядке
     * @param input file
     * @param output file
     * @return true - если записалось
     *          false - если начальный файл пустой
     * @throws IOException
     */
    public static boolean saveToFile(File input, File output) throws IOException {
        Set<String> words = readWords(input);
        if (words.size() == 0)
            return false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (String word : words) {
                writer.write(word + "\n");
            }
            return true;
        }
    }
}
