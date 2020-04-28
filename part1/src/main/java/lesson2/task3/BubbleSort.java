package lesson2.task3;


import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * @author 18395435
 * @created_at 27/04/2020 - 22:00
 * @project InnopolisUniversity
 */

public class BubbleSort implements AlgoSort<Person>{
    private Person[] persons;

    /**
     * Сортировка пузырьком
     * @param persons отсортированный массив
     */
    @Override
    public Person[] sort(Person[] persons) {
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
        return persons;
    }
}
