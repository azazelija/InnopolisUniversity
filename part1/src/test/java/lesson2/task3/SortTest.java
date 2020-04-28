package lesson2.task3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 18395435
 * @created_at 27/04/2020 - 22:43
 * @project InnopolisUniversity
 */
class SortTest {
    Person[] persons;
    Person[] personsException;

    BubbleSort bubbleSort = new BubbleSort();
    InsertSort insertSort = new InsertSort();

    @BeforeEach
    void setUp() {
        persons = new Person[10000];
        for (int i = 0; i < persons.length; i++) {
            int age = new Random().ints(0, 101).findFirst().getAsInt();
            Sex sex = i % 2 == 0 ? Sex.MALE : Sex.FEMALE;
            String name = RandomStringUtils.randomAlphabetic(10, 15);
            persons[i] = new Person(age, name, sex);
        }
        personsException = new Person[5];
        List<Person> list = new ArrayList<>();
        list.add(new Person(12, "D", Sex.MALE));
        list.add(new Person(12, "C", Sex.MALE));
        list.add(new Person(13, "B", Sex.MALE));
        list.add(new Person(13, "A", Sex.MALE));
        list.add(new Person(13, "A", Sex.MALE));
        personsException = list.toArray(new Person[list.size()]);
    }

    @Test
    void sort() {
        assertEquals(bubbleSort.sort(persons), insertSort.sort(persons));
        assertThrows(HandleException.class, () -> bubbleSort.sort(personsException));
        assertThrows(HandleException.class, () -> insertSort.sort(personsException));
    }
}