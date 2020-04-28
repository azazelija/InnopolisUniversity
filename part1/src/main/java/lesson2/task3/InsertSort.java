package lesson2.task3;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * @author 18395435
 * @created_at 27/04/2020 - 23:51
 * @project InnopolisUniversity
 */
public class InsertSort implements AlgoSort<Person>{
    private Person[] persons;

    /**
     * Сортировка вставками
     * @param persons отсортированный массив
     */
    @Override
    public Person[] sort(Person[] persons) {
        //  Сортировка по полу
        for (int i = 0; i < persons.length; i++) {
            int min = i;
            for (int j = i; j < persons.length; j++) {
                if (persons[j].compareTo(persons[min]) > 0) {
                    min = j;
                }
            }
            Person tmp = persons[i];
            persons[i] = persons[min];
            persons[min] = tmp;
        }
        // Сортировка по возрасту
        for (int i = 0; i < persons.length; i++) {
            int min = i;
            for (int j = i; j < persons.length; j++) {
                if (persons[j].compareTo(persons[min]) == 0) {
                    if (persons[j].getAge() - persons[min].getAge() > 0) {
                        min = j;
                    }
                }
            }
            Person tmp = persons[i];
            persons[i] = persons[min];
            persons[min] = tmp;
        }
        // Сортировка по имени
        for (int i = 0; i < persons.length; i++) {
            int min = i;
            for (int j = i; j < persons.length; j++) {
                if (persons[j].compareTo(persons[min]) == 0) {
                    if (persons[j].getAge() - persons[min].getAge() == 0) {
                        if (i != j) {
                            if (persons[j].getName().compareTo(persons[min].getName()) == 0)
                                throw new HandleException();
                        }
                        if (persons[j].getName().compareTo(persons[min].getName()) < 0) {
                            min = j;
                        }
                    }
                }
            }
            Person tmp = persons[i];
            persons[i] = persons[min];
            persons[min] = tmp;
        }
        return persons;
    }
}
