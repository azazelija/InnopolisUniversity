package lesson2.task3;


import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * @author 18395435
 * @created_at 27/04/2020 - 22:00
 * @project InnopolisUniversity
 */

public class BubbleSort {
    private Person[] persons;

    /**
     * Сортировка пузырьком
     * @param persons отсортированный массив
     */
    public void BubbleSort(Person[] persons) {
        Instant start = Instant.now();
        //  Сортировка по полу
        for (int i = persons.length; i > 0; i--) {
            for (int j = 1; j < persons.length; j++) {
                if (persons[j].compareTo(persons[j - 1]) > 0) {
                    Person tmp = persons[j];
                    persons[j] = persons[j - 1];
                    persons[j - 1] = tmp;
                }
            }
        }
        // Сортировка по возрасту
        for (int i = persons.length; i > 0; i--) {
            for (int j = 1; j < persons.length; j++) {
                if (persons[j].compareTo(persons[j - 1]) == 0) {
                    if (persons[j].getAge() - persons[j - 1].getAge() > 0) {
                        Person tmp = persons[j];
                        persons[j] = persons[j - 1];
                        persons[j - 1] = tmp;
                    }
                }
            }
        }
        // Сортировка по имени
        for (int i = persons.length; i > 0; i--) {
            for (int j = 1; j < persons.length; j++) {
                if (persons[j].compareTo(persons[j - 1]) == 0) {
                    if (persons[j].getAge() - persons[j - 1].getAge() == 0) {
                        if (persons[j].getName().compareTo(persons[j - 1].getName()) == 0)
                            throw new HandleException();
                        if (persons[j].getName().compareTo(persons[j - 1].getName()) < 0) {
                            Person tmp = persons[j];
                            persons[j] = persons[j - 1];
                            persons[j - 1] = tmp;
                        }
                    }
                }
            }
        }
        Instant end = Instant.now();
        Arrays.asList(persons).forEach(System.out::println);
        System.out.println("\nTimeDuration: " + Duration.between(start, end));
    }
}
